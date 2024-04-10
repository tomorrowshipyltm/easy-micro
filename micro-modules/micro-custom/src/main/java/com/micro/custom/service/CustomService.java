package com.micro.custom.service;

import com.micro.custom.dto.CustomDataView;

import java.util.List;

/**
 * 用户业务
 */
public interface CustomService {

    // 查询data
    List<CustomDataView> listData(int pageNum, int pageSize);

}
