package mybatisplusdemo.demo.cn.rabbitmq;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class UserA implements Serializable {
    private String name;
    private int age;
}
