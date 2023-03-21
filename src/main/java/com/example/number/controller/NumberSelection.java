package com.example.number.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.number.common.Result;
import com.example.number.domain.Number;
import com.example.number.domain.NumberVO;
import com.example.number.service.NumberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/numSel")
public class NumberSelection {

    @Autowired
    private NumberService numberService;

    /**
     * 查询
     * @param numberVO
     * @return
     */
    @PostMapping("/getNum")
    public Result getNum(@RequestBody NumberVO numberVO){
        PageHelper.startPage(numberVO.getPageNum(),numberVO.getPageSize());
        List<Number> numberList = numberService.list(new QueryWrapper<Number>().like("NUMBER",numberVO.getNumber()));
        PageInfo<Number> pageInfo = new PageInfo<>(numberList);
        return Result.createSuccess(pageInfo);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("getAllNum")
    public Result getAllNum(){
        return Result.createSuccess(numberService.list());
    }

    /**
     * 更新
     * @param number
     * @return
     */
    @PostMapping("/updateNum")
    public Result updateNum(@RequestBody Number number){
        boolean isUpdate = numberService.updateById(number);
        if (isUpdate){
            List<Number> numberList = numberService.list();

            WebSocketServer.sendAll(JSON.toJSONString(numberList));
            return Result.createSuccess(null);
        } else {
            return Result.createFalse(500,"fail",null);
        }
    }

}
