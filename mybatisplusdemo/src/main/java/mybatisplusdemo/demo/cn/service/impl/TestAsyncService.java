package mybatisplusdemo.demo.cn.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestAsyncService {
    Logger log = LoggerFactory.getLogger(TestAsyncService.class);
    // 发送提醒短信 1
    @Async("taskExecutor")
    public void service1() throws InterruptedException {
        log.info("--------start-service1------------");
        Thread.sleep(5000); // 模拟耗时
        log.info("--------end-service1------------");
    }
}
