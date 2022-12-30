package ltd.newbee.cloud.param;

import lombok.Getter;
import lombok.Setter;
import ltd.newbee.cloud.entity.NewBeeCartItem;
import ltd.newbee.cloud.entity.NewBeeGoodsInfo;

import java.util.List;

@Getter
@Setter
public class ComplexObject {
    private int requestNum;

    private List<Integer> cartIds;

    private List<NewBeeGoodsInfo> newBeeGoodsInfos;

    private NewBeeCartItem newBeeCartItem;

    @Override
    public String toString() {
        return "ComplexObject{" +
                "requestNum=" + requestNum +
                ", cartIds=" + cartIds +
                ", newBeeGoodsInfos=" + newBeeGoodsInfos +
                ", newBeeCartItem=" + newBeeCartItem +
                '}';
    }
}
