package com.easy.micro.mapper.dataset;

import com.easy.micro.model.dataset.DatasetExample;
import com.easy.micro.model.dataset.DatasetView;

import java.util.List;

public interface DatasetMapper {

    List<DatasetView> selectByExample(DatasetExample example);

    DatasetView selectByPrimaryKey(Long id);

    int deleteByExample(DatasetExample example);

    int deleteByPrimaryKey(Long id);
}