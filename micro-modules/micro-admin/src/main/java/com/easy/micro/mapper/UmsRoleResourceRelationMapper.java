package com.easy.micro.mapper;

import com.easy.micro.model.UmsRoleResourceRelation;
import com.easy.micro.model.UmsRoleResourceRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleResourceRelationMapper {
    long countByExample(UmsRoleResourceRelationExample example);

    int deleteByExample(UmsRoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleResourceRelation record);

    int insertSelective(UmsRoleResourceRelation record);

    List<UmsRoleResourceRelation> selectByExample(UmsRoleResourceRelationExample example);

    UmsRoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsRoleResourceRelation record, @Param("example") UmsRoleResourceRelationExample example);

    int updateByExample(@Param("record") UmsRoleResourceRelation record, @Param("example") UmsRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(UmsRoleResourceRelation record);

    int updateByPrimaryKey(UmsRoleResourceRelation record);
}