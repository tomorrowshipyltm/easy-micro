package com.micro.custom.service.impl;

import com.micro.custom.dto.CustomDataView;
import com.micro.custom.service.CustomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务api，最终聚合到micro-admin 接口，gateway对外统一暴露
 * 这里模拟返回数据
 */
@Service
public class CustomServiceImpl implements CustomService {

    @Override
    public List<CustomDataView> listData(int pageNum, int pageSize) {
        List<CustomDataView> result = new ArrayList<>();
        CustomDataView customData1 = new CustomDataView(1L, "Health", "Number of Schools by Management", "http://localhost/files/RS_Session.csv");
        CustomDataView customData2 = new CustomDataView(2L, "Science", "Education and Gender during 2020-21", "http://localhost/files/fish.mp4");
        CustomDataView customData3 = new CustomDataView(3L, "Economy", "Wholesale Price Index ", "http://localhost/files/visualize.pdf");
        result.add(customData1);
        result.add(customData2);
        result.add(customData3);
        return result;
    }
}
