package com.lei.tool.utils.socket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * websocket
 * 消息推送(个人和广播)
 */
@Controller
@RequestMapping("/webSocket")
public class WebSocketController {

	/**
	 * 个人信息推送
	 *
	 * @return
	 */
	@RequestMapping("/sendToSingle")
	@ResponseBody
	public String sendToSingle(String msg, String userId) {
		SocketServer.sendMessage(msg, userId);
		return "success";
	}

	/**
	 * 多人信息推送
	 *
	 * @return
	 */
	@RequestMapping("/sendToMany")
	@ResponseBody
	public String sendToMany(String msg, String userIds) {
		String[] persons = userIds.split(",");
		SocketServer.SendMany(msg, persons);
		return "success";
	}

	/**
	 * 推送给所有在线用户
	 *
	 * @return
	 */
	@RequestMapping("/sendToAll")
	@ResponseBody
	public String sendToAll(String msg) {
		SocketServer.sendAll(msg);
		return "success";
	}

	/**
	 * 获取当前在线用户
	 *
	 * @return
	 */
	@RequestMapping("/webStatus")
	public String webStatus() {
		//当前用户个数
		int count = SocketServer.getOnlineNum();
		//当前在线所有用户
		String names = SocketServer.getOnlineUsers();
		return count + names;
	}
}