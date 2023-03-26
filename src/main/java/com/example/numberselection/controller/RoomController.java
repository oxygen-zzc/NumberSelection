package com.example.numberselection.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.numberselection.common.Result;
import com.example.numberselection.domain.Room;
import com.example.numberselection.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/getRoom")
    public Result getRoom(@RequestBody Room room){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("BUILDING_NO",room.getBuildingNo());
        wrapper.eq("UNIT",room.getUnit());
        wrapper.eq("ROOM_NO",room.getRoomNo());
        wrapper.orderBy(true,false,"FLOOR");

        return Result.createSuccess(roomService.list(wrapper));
    }

    @PostMapping("/updateRoom")
    public Result updateRoom(@RequestBody Room room){
        boolean isUpdate = roomService.updateById(room);
        if (isUpdate){
            return Result.createSuccess(null);
        } else {
            return Result.createFalse(500,"更新失败",null);
        }
    }

}
