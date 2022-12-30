package ltd.newbee.cloud.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBeeGoodsInfo {

    private int goodsId;

    private String goodsName;

    private int stock;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(" goodsName=").append(goodsName);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", stock=").append(stock);
        sb.append("]");
        return sb.toString();
    }
}
