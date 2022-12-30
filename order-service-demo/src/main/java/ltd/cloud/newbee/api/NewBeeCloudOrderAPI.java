package ltd.cloud.newbee.api;

import ltd.cloud.newbee.openfeign.NewBeeGoodsDemoService;
import ltd.cloud.newbee.openfeign.NewBeeShopCartDemoService;
import ltd.cloud.newbee.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;

    @Resource
    private OrderService orderService;

    @GetMapping("/order/saveOrder")
    public Boolean saveOrder(@RequestParam("cartId") int cartId) {
        return orderService.saveOrder(cartId);
    }

//    @GetMapping("/order/saveOrder")
//    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {
//        // 简单的模拟下单流程，包括服务间的调用流程。后续openfeign相关的改造和优化将基于当前项目进行改造。
//
//        // 调用商品服务
//        String goodsResult = newBeeGoodsDemoService.getGoodsDetail(goodsId);
//
//        // 调用购物车服务
//        String cartResult = newBeeShopCartDemoService.getCartItemDetail(cartId);
//
//        // 执行下单逻辑
//
//        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
//    }
}
