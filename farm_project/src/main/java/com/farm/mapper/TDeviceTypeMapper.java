package com.farm.mapper;

import com.farm.model.TDeviceType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TDeviceTypeMapper {

    Page<TDeviceType> selectTDeviceTypePage(String queryString);

    TDeviceType selectTDeviceTypeById(long id);

    int insertTDeviceType(TDeviceType tDeviceType);

    int updateTDeviceType(TDeviceType tDeviceType);

    int deleteTDeviceTypeById(long id);

    List<TDeviceType> selectTDeviceTypeAll();

}
