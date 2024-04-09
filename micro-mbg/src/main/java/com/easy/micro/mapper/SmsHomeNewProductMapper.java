package com.easy.micro.mapper;

import com.easy.micro.model.SmsHomeNewProduct;
import com.easy.micro.model.SmsHomeNewProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeNewProductMapper {
    long countByExample(SmsHomeNewProductExample example);

    int deleteByExample(SmsHomeNewProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeNewProduct record);

    int insertSelective(SmsHomeNewProduct record);

    List<SmsHomeNewProduct> selectByExample(SmsHomeNewProductExample example);

    SmsHomeNewProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeNewProduct record, @Param("example") SmsHomeNewProductExample example);

    int updateByExample(@Param("record") SmsHomeNewProduct record, @Param("example") SmsHomeNewProductExample example);

    int updateByPrimaryKeySelective(SmsHomeNewProduct record);

    int updateByPrimaryKey(SmsHomeNewProduct record);
}