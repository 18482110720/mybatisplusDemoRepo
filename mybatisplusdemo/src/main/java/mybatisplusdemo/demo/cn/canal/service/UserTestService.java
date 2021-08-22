package mybatisplusdemo.demo.cn.canal.service;

import org.springframework.stereotype.Service;

@Service
public class UserTestService extends abstractService{
    @Override
    public void insert1() {
        System.out.println("调用了userService类的insert1方法");
    }
}
