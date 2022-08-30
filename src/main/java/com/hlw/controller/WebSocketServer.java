package com.hlw.controller;

import com.hlw.utils.WebSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * WebSocketServer
 *
 * @author hcf
 * @date 2022/1/6 17:57
 */
@Component
@ServerEndpoint(value = "/websocket/{appNo}")
public class WebSocketServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

    @OnOpen
    public void onOpen(@PathParam("appNo") String appNo, Session session) {//指定连接成功后的回调函数。
        LOGGER.info("用户【{}】于 {} 时间，与服务器建立 websocket 连接!", appNo, new Date());
        WebSocketUtil.addSession(appNo, session);
    }

    @OnClose
    public void onClose(@PathParam("appNo") String appNo) {//指定断开连接后的回调函数。
        LOGGER.info("用户【{}】于 {} 时间，与服务器断开 websocket 连接!", appNo, new Date());
        WebSocketUtil.remoteSession(appNo);
    }

    @OnMessage
    public void onMessage(@PathParam("appNo") String appNo, String message) {//指定收到服务器数据后的回调函数。
        LOGGER.info("服务器于 {} 时间，对用户【{}】发送消息，消息内容：{}", new Date(), appNo, message);
        Session session = WebSocketUtil.ONLINE_SESSION.get(appNo);
        if (Objects.isNull(session)) {
            LOGGER.info("服务器和用户【{}】之间的链接已断开", appNo);
            return;
        }
        Boolean success = WebSocketUtil.sendMessage(appNo, session, message);
        LOGGER.info("客户端向服务端发送消息结果：{}", success);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        LOGGER.error("服务器和用户之间的链接产生异常，异常原因：{}", throwable.getMessage(), throwable);
        try {
            session.close();
        } catch (IOException e) {
            LOGGER.error("断开服务器和用户之间的链接产生异常，异常原因：{}", e.getMessage(), e);
        }
    }
}
