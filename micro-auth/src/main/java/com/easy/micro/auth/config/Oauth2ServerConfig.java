package com.easy.micro.auth.config;

import com.easy.micro.auth.component.JwtTokenEnhancer;
import com.easy.micro.auth.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务器配置
 *
 * The gateway typically performs initial validation of the access token.
 * The purpose of this validation is to ensure that the token is properly signed and not expired before forwarding the request to the backend microservices.
 * However, it is still important for the backend microservices to independently validate the access token for the reasons mentioned earlier.
 * Here's why backend microservices should perform their own token validation, even if the gateway has already done so:
 * Defense in Depth: Implementing token validation at multiple layers adds an extra layer of security known as defense in depth. If, by any chance, a request bypasses the gateway or the gateway's validation is compromised, the backend microservices can act as an additional security barrier by performing their own validation.
 *
 * Authorization Scope and Permissions: The backend microservices need to perform their own validation to check if the access token's scope and permissions are appropriate for the specific resource or action being requested. The gateway might perform a general validation, but the microservices have a more detailed understanding of their specific resource access requirements.
 *
 * Microservice Independence: Validating the access token within each microservice allows them to operate independently. It enables microservices to be developed, deployed, and scaled independently without being tightly coupled or reliant on the gateway for token validation. This promotes modularity and flexibility within the system architecture.
 *
 * Custom Validation Logic: Backend microservices may have additional business-specific validation requirements that go beyond the basic validation performed by the gateway. They might need to check additional token claims, validate against custom rules, or perform context-specific checks. By performing their own validation, microservices have the flexibility to implement custom logic as needed.
 *
 * In summary, while the gateway performs initial access token validation, it is still important for the backend microservices to independently validate the token. This ensures an additional layer of security, allows for more granular authorization control, promotes microservice independence, and enables custom validation logic based on specific business requirements.
 */
@AllArgsConstructor
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenEnhancer jwtTokenEnhancer;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin-app")
                .secret(passwordEncoder.encode("123456"))
                .scopes("all")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600*24)
                .refreshTokenValiditySeconds(3600*24*7)
                .and()
                .withClient("portal-app")
                .secret(passwordEncoder.encode("123456"))
                .scopes("all")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600*24)
                .refreshTokenValiditySeconds(3600*24*7);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService) //配置加载用户信息的服务
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(enhancerChain);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }

    @Bean
    public KeyPair keyPair() {
        //从classpath下的证书中获取秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
    }

}
