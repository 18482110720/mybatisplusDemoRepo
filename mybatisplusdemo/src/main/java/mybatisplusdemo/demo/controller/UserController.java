package mybatisplusdemo.demo.controller;


import mybatisplusdemo.demo.cn.entity.User;
import mybatisplusdemo.demo.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyx
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User>  getResSeriesPage() {
        List<User> list = userService.getUserList(Arrays.asList(1L, 2L, 3L, 4L, 5L), "a");
        return list;
    }

}
