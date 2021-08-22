package mybatisplusdemo.demo.cn.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import mybatisplusdemo.demo.cn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where id =#{id}")
    User getUId(@Param("id")Long id);
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> getUserList(@Param(Constants.WRAPPER)QueryWrapper<User> queryMapper);
}
