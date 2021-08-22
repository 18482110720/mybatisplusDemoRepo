package mybatisplusdemo.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatisplusdemo.demo.cn.entity.User;
import mybatisplusdemo.demo.cn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void Test01() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

    }

    @Test
    void Test02() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //queryWrapper.eq("id",1);
       // queryWrapper.like("name","a");
        queryWrapper.in("id", Arrays.asList("1","2")).select("name");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    void Test03() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a");
        Page page=new Page();
        page.setSize(1);
        page.setCurrent(2);
        Page page1 = userMapper.selectPage(page, queryWrapper);
        System.out.println();
        System.out.println(page1.getRecords());

    }

    @Test
    void Test04() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().like(User::getName,"a");
        Page page=new Page();
        page.setSize(1);
        page.setCurrent(2);
        Page page1 = userMapper.selectPage(page, queryWrapper);
        System.out.println();
        System.out.println(page1.getRecords());

    }



}
