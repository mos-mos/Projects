package com.construction.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.mapper.DevelopMapper;
import com.construction.model.Developer;
import com.construction.service.DevelopService;
import org.springframework.stereotype.Service;

@Service
public class DevelopServiceImpl extends ServiceImpl<DevelopMapper, Developer> implements DevelopService {

}
