package com.easy.micro.mapper;

import com.easy.micro.model.PmsAlbum;
import com.easy.micro.model.PmsAlbumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAlbumMapper {
    long countByExample(PmsAlbumExample example);

    int deleteByExample(PmsAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsAlbum record);

    int insertSelective(PmsAlbum record);

    List<PmsAlbum> selectByExample(PmsAlbumExample example);

    PmsAlbum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsAlbum record, @Param("example") PmsAlbumExample example);

    int updateByExample(@Param("record") PmsAlbum record, @Param("example") PmsAlbumExample example);

    int updateByPrimaryKeySelective(PmsAlbum record);

    int updateByPrimaryKey(PmsAlbum record);
}