package com.farm.mapper;

import com.farm.model.TDevice;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TDeviceMapper {
    Page<TDevice> selectTDevicePage(String queryString);

    TDevice selectTDeviceById(long id);

    int insertTDevice(TDevice tDevice);

    int updateTDevice(TDevice tDevice);

    int deleteTDeviceById(long id);
}
