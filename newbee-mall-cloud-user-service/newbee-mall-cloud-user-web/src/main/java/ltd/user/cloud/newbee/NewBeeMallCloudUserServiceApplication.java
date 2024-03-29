package ltd.user.cloud.newbee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("ltd.user.cloud.newbee.dao")
public class NewBeeMallCloudUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewBeeMallCloudUserServiceApplication.class, args);
    }
}
