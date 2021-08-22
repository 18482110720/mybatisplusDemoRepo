package mybatisplusdemo.demo.cn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mybatisplusdemo.demo.cn.entity.User;
import mybatisplusdemo.demo.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserService extends IService<User> {



    public User getUId(Long id);

    public List<User>getUserList(List<Long> userId, String userName);
}
