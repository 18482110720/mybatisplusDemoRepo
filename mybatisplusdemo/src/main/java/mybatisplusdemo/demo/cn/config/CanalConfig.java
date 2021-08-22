package mybatisplusdemo.demo.cn.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CanalConfig {

    @PostConstruct
    public void initMethod(){
       System.out.println("---------------启动时调用了该方法");
       System.out.println("---------------启动时调用了该方法");
    }
}
