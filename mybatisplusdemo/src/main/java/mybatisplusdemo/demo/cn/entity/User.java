package mybatisplusdemo.demo.cn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@TableName("user")
@Data
public class User {
    private Long id;

    private String name;

    private Integer age;
    private String email;

    @TableLogic
    private Integer isDelete;


}
