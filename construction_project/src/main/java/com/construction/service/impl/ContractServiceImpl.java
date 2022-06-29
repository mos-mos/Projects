package com.construction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.construction.mapper.ContractMapper;
import com.construction.model.Contractor;
import com.construction.service.ContractService;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contractor> implements ContractService {

}
