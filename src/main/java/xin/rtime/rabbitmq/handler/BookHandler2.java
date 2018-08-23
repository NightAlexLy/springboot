package xin.rtime.rabbitmq.handler;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.rabbitmq.client.Channel;

import xin.rtime.rabbitmq.config.RabbitConfig2;
import xin.rtime.rabbitmq.model.Book;

/**
 * 
 * Chapter11 Handler
 * 
 *   BOOK_QUEUE 消费者
 *
 */
public class BookHandler2 {

    private static final Logger log = LoggerFactory.getLogger(BookHandler.class);

    @RabbitListener(queues = {RabbitConfig2.REGISTER_QUEUE_NAME})
    public void listenerDelayQueue(Book book, Message message, Channel channel) {
        log.info("[listenerDelayQueue 监听的消息] - [消费时间] - [{}] - [{}]", LocalDateTime.now(), book.toString());
        try {
            // TODO 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // TODO 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }
}
