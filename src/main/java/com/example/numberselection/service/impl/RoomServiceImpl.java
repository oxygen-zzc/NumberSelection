package com.example.numberselection.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.numberselection.domain.Room;
import com.example.numberselection.mapper.RoomMapper;
import com.example.numberselection.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper,Room> implements RoomService {
}
