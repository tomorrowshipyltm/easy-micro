package com.easy.micro.mapper;

import com.easy.micro.model.CmsHelp;
import com.easy.micro.model.CmsHelpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsHelpMapper {
    long countByExample(CmsHelpExample example);

    int deleteByExample(CmsHelpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsHelp record);

    int insertSelective(CmsHelp record);

    List<CmsHelp> selectByExampleWithBLOBs(CmsHelpExample example);

    List<CmsHelp> selectByExample(CmsHelpExample example);

    CmsHelp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsHelp record, @Param("example") CmsHelpExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsHelp record, @Param("example") CmsHelpExample example);

    int updateByExample(@Param("record") CmsHelp record, @Param("example") CmsHelpExample example);

    int updateByPrimaryKeySelective(CmsHelp record);

    int updateByPrimaryKeyWithBLOBs(CmsHelp record);

    int updateByPrimaryKey(CmsHelp record);
}