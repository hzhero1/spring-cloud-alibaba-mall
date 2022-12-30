package ltd.cloud.newbee.openfeign;

import ltd.newbee.cloud.entity.NewBeeGoodsInfo;
import ltd.newbee.cloud.param.ComplexObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "newbee-cloud-goods-service", path = "/goods")
public interface NewBeeGoodsDemoService {
    @GetMapping(value = "/{goodsId}")
    String getGoodsDetail(@PathVariable(value = "goodsId") int goodsId);

    @GetMapping(value = "/detail")
    String getGoodsDetail3(@RequestParam(value = "goodsId") int goodsId, @RequestParam(value = "sellStatus") int sellStatus);

    @GetMapping(value = "/listByIdArray")
    List<String> getGoodsArray(@RequestParam(value = "goodsIds") Integer[] goodsIds);

    @GetMapping(value = "/listByIdList")
    List<String> getGoodsList(@RequestParam(value = "goodsIds") List<Integer> goodsIds);

    @PostMapping(value = "/updNewBeeGoodsInfo")
    NewBeeGoodsInfo updNewBeeGoodsInfo(@RequestBody NewBeeGoodsInfo newBeeGoodsInfo);

    @PostMapping(value = "/testComplexObject")
    ComplexObject testComplexObject(@RequestBody ComplexObject complexObject);

    @PutMapping(value = "/{goodsId}")
    Boolean deStock(@PathVariable(value = "goodsId") int goodsId);
}
