
package ltd.shopcart.cloud.newbee;

import ltd.goods.cloud.newbee.openfeign.NewBeeCloudGoodsServiceFeign;
import ltd.user.cloud.newbee.openfeign.NewBeeCloudUserServiceFeign;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 程序员十三
 * @qq交流群 791509631
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("ltd.shopcart.cloud.newbee.dao")
@EnableFeignClients(basePackageClasses ={NewBeeCloudUserServiceFeign.class, NewBeeCloudGoodsServiceFeign.class})
public class NewBeeMallCloudShopCartServiceApplication {

    public static void main(String[] args) {
        System.setProperty("nacos.logging.default.config.enabled","false");
        SpringApplication.run(NewBeeMallCloudShopCartServiceApplication.class, args);
    }

}
