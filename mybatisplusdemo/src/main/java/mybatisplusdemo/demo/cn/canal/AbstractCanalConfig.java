package mybatisplusdemo.demo.cn.canal;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AbstractCanalConfig {
    protected String ip;

    protected String port;

    protected String username;

    protected String password;

    protected Long executeTime;

    protected String filter;

    protected String destination;
}
