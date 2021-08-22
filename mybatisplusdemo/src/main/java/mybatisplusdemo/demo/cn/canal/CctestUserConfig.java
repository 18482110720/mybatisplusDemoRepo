package mybatisplusdemo.demo.cn.canal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("order-test-user")
public class CctestUserConfig extends AbstractCanalConfig{
}
