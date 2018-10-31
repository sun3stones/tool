package com.lei.tool.utils.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/socketServer/{userId}")
@Component
public class SocketServer {

    private static Logger logger = LoggerFactory.getLogger(SocketServer.class);

    private Session session;
    private static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> sessionIds = new ConcurrentHashMap<>();

    /**
     * 用户连接时触发
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void open(Session session, @PathParam(value = "userId") String userId) {
        this.session = session;
        sessionPool.put(userId, session);
        sessionIds.put(session.getId(), userId);
        logger.info("接入新用户，用户id:"+userId+";当前连接数"+getOnlineNum());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        sendMessage(sessionIds.get(session.getId()) + "<--" + message, sessionIds.get(session.getId()));
    }

    /**
     * 连接关闭触发
     */
    @OnClose
    public void onClose() {
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
    }

    /**
     * 发生错误时触发
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 信息发送的方法
     *
     * @param message
     * @param userId
     */
    public static void sendMessage(String message, String userId) {
        Session session = sessionPool.get(userId);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取当前连接数
     *
     * @return
     */
    public static int getOnlineNum() {
        if (sessionIds.values().contains("0")) {
            return sessionPool.size() - 1;
        }
        return sessionPool.size();
    }

    /**
     * 获取在线用户名以逗号隔开
     *
     * @return
     */
    public static String getOnlineUsers() {
        StringBuffer users = new StringBuffer();
        for (String key : sessionIds.keySet()) {//0是服务端自己的连接，不能算在线人数
            if (!"0".equals(sessionIds.get(key))) {
                users.append(sessionIds.get(key) + ",");
            }
        }
        return users.toString();
    }

    /**
     * 信息群发
     *
     * @param msg
     */
    public static void sendAll(String msg) {
        for (String key : sessionIds.keySet()) {
            if (!"0".equals(sessionIds.get(key))) {
                sendMessage(msg, sessionIds.get(key));
            }
        }
    }

    /**
     * 多个人发送给指定的几个用户
     *
     * @param msg
     * @param userIds 用户s
     */

    public static void SendMany(String msg, String[] userIds) {
        for (String userId : userIds) {
            sendMessage(msg, userId);
        }
    }
}