package mybatisplusdemo.demo.cn.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    String exchangename="zhangminexchange";


    public void sendMessage(){
        UserA userA =new UserA();
        userA.setName("zhangasan");
        userA.setAge(18);
        rabbitTemplate.convertAndSend(exchangename,"key1", userA);
    }
}
