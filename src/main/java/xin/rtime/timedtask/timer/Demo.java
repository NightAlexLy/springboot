package xin.rtime.timedtask.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/***
 * 
 *  Chapter15 验证JDK自带的Timer
 *
 */
public class Demo {

	public static void main(String[] args) {
		
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务:" + LocalDateTime.now());
            }
        };
        Timer timer = new Timer();
        // timerTask：需要执行的任务
        // delay：延迟时间（以毫秒为单位）
        // period：间隔时间（以毫秒为单位）
        timer.schedule(timerTask, 5000, 3000);
		
	}
}
