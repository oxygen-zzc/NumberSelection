package com.example.numberselection.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.numberselection.common.Result;
import com.example.numberselection.domain.Building;
import com.example.numberselection.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/getAllBuilding")
    public Result getAllBuilding(){
        return Result.createSuccess(buildingService.list(new QueryWrapper<Building>().orderBy(true,true,"BUILDING_NO")));
    }
}
