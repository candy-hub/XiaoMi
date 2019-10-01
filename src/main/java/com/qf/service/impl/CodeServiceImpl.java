package com.qf.service.impl;

import com.qf.dao.CodeRepository;
import com.qf.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeRepository codeRepository;



}
