package com.easy.micro.mapper;

import com.easy.micro.model.CmsSubject;
import com.easy.micro.model.CmsSubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsSubjectMapper {
    long countByExample(CmsSubjectExample example);

    int deleteByExample(CmsSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsSubject record);

    int insertSelective(CmsSubject record);

    List<CmsSubject> selectByExampleWithBLOBs(CmsSubjectExample example);

    List<CmsSubject> selectByExample(CmsSubjectExample example);

    CmsSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    int updateByExample(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    int updateByPrimaryKeySelective(CmsSubject record);

    int updateByPrimaryKeyWithBLOBs(CmsSubject record);

    int updateByPrimaryKey(CmsSubject record);
}