package mybatisplusdemo.demo.cn.canal.service;

import mybatisplusdemo.demo.cn.canal.AbstractCanalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class abstractService {




    public void say1(AbstractCanalConfig config){
        System.out.println("调用了公共方法say1,config:"+config);
        insert1();
    }

    public abstract void insert1();
}
