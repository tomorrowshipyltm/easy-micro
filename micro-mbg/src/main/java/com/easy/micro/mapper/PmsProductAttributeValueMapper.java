package com.easy.micro.mapper;

import com.easy.micro.model.PmsProductAttributeValue;
import com.easy.micro.model.PmsProductAttributeValueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductAttributeValueMapper {
    long countByExample(PmsProductAttributeValueExample example);

    int deleteByExample(PmsProductAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeValue record);

    int insertSelective(PmsProductAttributeValue record);

    List<PmsProductAttributeValue> selectByExample(PmsProductAttributeValueExample example);

    PmsProductAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductAttributeValue record, @Param("example") PmsProductAttributeValueExample example);

    int updateByExample(@Param("record") PmsProductAttributeValue record, @Param("example") PmsProductAttributeValueExample example);

    int updateByPrimaryKeySelective(PmsProductAttributeValue record);

    int updateByPrimaryKey(PmsProductAttributeValue record);
}