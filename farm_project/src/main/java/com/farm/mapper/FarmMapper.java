package com.farm.mapper;

import com.farm.model.TFarm;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmMapper {

    Page<TFarm> selectTFarmPage(String queryString);

    int insertTFarm(TFarm farm);

    int updateTFarm(TFarm farm);

    int deleteTFarmById(long id);

    TFarm selectTFarmById(long id);

    List<TFarm> selectTFarmAll();
}
