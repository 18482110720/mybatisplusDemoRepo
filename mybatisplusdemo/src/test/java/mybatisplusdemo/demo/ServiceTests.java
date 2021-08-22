package mybatisplusdemo.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatisplusdemo.demo.cn.canal.AbstractCanalConfig;
import mybatisplusdemo.demo.cn.canal.CcProgramCanalConfig;
import mybatisplusdemo.demo.cn.canal.CctestUserConfig;
import mybatisplusdemo.demo.cn.canal.service.ProgramService;
import mybatisplusdemo.demo.cn.canal.service.UserTestService;
import mybatisplusdemo.demo.cn.entity.User;
import mybatisplusdemo.demo.cn.rabbitmq.Producer;
import mybatisplusdemo.demo.cn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTests {
    @Autowired
    private UserService userService;

    @Autowired
    private Producer producer;
    @Autowired
    private UserTestService userTestService;

    @Autowired
    private ProgramService programService;

    @Test
    void Test01() {
        List<User> list = userService.list();
        list.forEach(System.out::println);

    }
    @Test
    void Test02() {
        QueryWrapper<User> wrapper= new QueryWrapper<User>();
        wrapper.lambda().eq(User::getId,1);
        User one = userService.getOne(wrapper);
        System.out.println(one);
    }

    @Test
    void Test03() {
        QueryWrapper<User> wrapper= new QueryWrapper<User>();
        wrapper.lambda().like(User::getName,"a");
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }

    @Test
    void Test04() {
        QueryWrapper<User> wrapper= new QueryWrapper<User>();
        wrapper.lambda().like(User::getName,"a");
        Page page = userService.page(new Page(2, 1), wrapper);
        System.out.println(page.getRecords());
    }

    @Test
    void Test05() {
        QueryWrapper<User> wrapper= new QueryWrapper<User>();
         wrapper.lambda().in(User::getId, Arrays.asList(1, 2, 3));
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }
    @Test
    void Test06() {
        QueryWrapper<User> wrapper= new QueryWrapper<User>();
        wrapper.lambda().in(User::getId, Arrays.asList(1, 2, 3,4,5))
                        .and(i->i.like(User::getName,"a").or(b->b.like(User::getName,"b")));


        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }

    @Test
    void Test07() {
        User user = userService.getUId(1L);
        System.out.println(user);
    }

    @Test
    void Test08() {
        List<User> userList = userService.getUserList(Arrays.asList(1L, 2L, 3L, 4L, 5L), "a");
        System.out.println(userList);
    }

    @Test
    void Test09() {
        producer.sendMessage();
    }

    @Autowired
    protected CcProgramCanalConfig programConfig;
    @Autowired
    protected CctestUserConfig cctestUserConfig;

    @Test
    void Test10() {
        userTestService.say1(cctestUserConfig);
        programService.say1(programConfig);
    }
}
