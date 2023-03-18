package com.example.number.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.number.domain.Number;
import com.example.number.mapper.NumberMapper;
import com.example.number.service.NumberService;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl extends ServiceImpl<NumberMapper, Number> implements NumberService {
}
