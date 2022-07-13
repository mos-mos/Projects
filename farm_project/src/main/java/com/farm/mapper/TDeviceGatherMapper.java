package com.farm.mapper;

import com.farm.model.TDeviceGather;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TDeviceGatherMapper {

    Page<TDeviceGather> selectTDeviceGatherPage(String queryString);

    TDeviceGather selectTDeviceGatherById(long id);

    int insertTDeviceGather(TDeviceGather tDeviceGather);

    int updateTDeviceGather(TDeviceGather tDeviceGather);

    int deleteTDeviceGatherById(int id);
}
