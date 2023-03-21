package com.example.number.controller;

import com.alibaba.fastjson.JSON;
import com.example.number.domain.Number;
import com.example.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/number")
@Component
public class WebSocketServer {

    private static NumberService numberService;

    @Autowired
    public void setNumberService(NumberService numberService){
        this.numberService = numberService;
    }

    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session){
        clients.put(session.getId(),session);
        List<Number> numberList = numberService.list();
        System.out.println(JSON.toJSONString(numberList));
        sendAll(JSON.toJSONString(numberList));
    }

    @OnClose
    public void onClose(Session session){
        clients.remove(session.getId());
    }

    @OnError
    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println(message);
    }

    public static void sendAll(String message){
        for (Map.Entry<String,Session> sessionEntry : clients.entrySet()){
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }

}
