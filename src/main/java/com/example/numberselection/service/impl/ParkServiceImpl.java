package com.example.numberselection.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.numberselection.domain.Park;
import com.example.numberselection.mapper.ParkMapper;
import com.example.numberselection.service.ParkService;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl extends ServiceImpl<ParkMapper, Park> implements ParkService {
}
