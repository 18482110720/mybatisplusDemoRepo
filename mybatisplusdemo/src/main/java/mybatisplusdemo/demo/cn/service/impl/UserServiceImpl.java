package mybatisplusdemo.demo.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatisplusdemo.demo.cn.entity.User;
import mybatisplusdemo.demo.cn.mapper.UserMapper;
import mybatisplusdemo.demo.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    TestAsyncService testAsyncService;

    @Override
    public User getUId(Long id) {
        User user = userMapper.getUId((id));
        return user;
    }

    @Override
    public List<User> getUserList(List<Long> userIdList, String userName) {

        QueryWrapper<User> queryMapper=new QueryWrapper<User>();

        queryMapper.lambda().in(User::getId,userIdList).like(User::getName,userName);

        List<User>userList=userMapper.getUserList(queryMapper);

        try {
            testAsyncService.service1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
