package mybatisplusdemo.demo.cn.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="zhangminqueue")
    public void consumerMessage(UserA userA){
        System.out.println("22222222222:"+ userA);
    }
}
