package xin.rtime;

import static xin.rtime.websocket.utils.WebSocketUtils.LIVING_SESSIONS_CACHE;
import static xin.rtime.websocket.utils.WebSocketUtils.sendMessage;
import static xin.rtime.websocket.utils.WebSocketUtils.sendMessageAll;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 
 *   示例21 ：
 *   
 *      Spring boot websocket
 *      
 *   引入依赖：
 *   
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-websocket</artifactId>
 *	    </dependency>
 *
 *
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
@SpringBootApplication
public class Chapter21Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter21Application.class, args);
	}

    private static final Logger log = LoggerFactory.getLogger(Chapter21Application.class);
    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        log.info(message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        LIVING_SESSIONS_CACHE.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }


    @GetMapping("/chat-room/{sender}/to/{receive}")
    public void onMessage(@PathVariable("sender") String sender, @PathVariable("receive") String receive, String message) {
        sendMessage(LIVING_SESSIONS_CACHE.get(receive), "[" + sender + "]" + "-> [" + receive + "] : " + message);
    }

}
