package com.example.numberselection.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.numberselection.domain.Building;
import com.example.numberselection.mapper.BuildingMapper;
import com.example.numberselection.service.BuildingService;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {
}
