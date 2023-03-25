package com.example.numberselection.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.example.numberselection.common.Result;
import com.example.numberselection.domain.Park;
import com.example.numberselection.domain.ParkVO;
import com.example.numberselection.service.ParkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private ParkService parkService;

    @PostMapping("/getPark")
    public Result getPark(@RequestBody ParkVO parkVO){
        PageHelper.startPage(parkVO.getPageNum(),parkVO.getPageSize());
        List<Park> parkList = parkService.list(new QueryWrapper<Park>().like("PARK_NUMBER",parkVO.getParkNumber()));
        PageInfo<Park> pageInfo = new PageInfo<>(parkList);
        return Result.createSuccess(pageInfo);
    }

    @GetMapping("/getAllPark")
    public Result getAllPark(){
        return Result.createSuccess(parkService.list());
    }

    @PostMapping("/updatePark")
    public Result updatePark(@RequestBody Park park){
        boolean isUpdate = parkService.updateById(park);
        if (isUpdate){
            return Result.createSuccess(null);
        } else {
            return Result.createFalse(500,"fail",null);
        }
    }
}
