package com.example.number.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.number.common.Result;
import com.example.number.domain.Number;
import com.example.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numSel")
public class NumberSelection {

    @Autowired
    private NumberService numberService;

    @GetMapping("/getAllNum")
    public Result getAllNum(){
        List<Number> numberList = numberService.list();
        return Result.createSuccess(numberList);
    }

    @PostMapping("/updateNum")
    public Result updateNum(@RequestBody Number number){
        boolean isUpdate = numberService.updateById(number);
        if (isUpdate){
            return Result.createSuccess(null);
        } else {
            return Result.createFalse(500,"fail",null);
        }
    }

}
