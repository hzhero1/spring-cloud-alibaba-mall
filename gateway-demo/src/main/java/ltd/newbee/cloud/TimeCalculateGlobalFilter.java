package ltd.newbee.cloud;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TimeCalculateGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求开始时间
        long startTime = System.currentTimeMillis();
        String requestURL = String.format("Host:%s Path:%s Params:%s",
                exchange.getRequest().getURI().getHost(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getQueryParams());

        System.out.println(requestURL);

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // 请求结束时间
            long endTime = System.currentTimeMillis();
            // 打印调用时间
            long requestTime = endTime - startTime;

            System.out.println(exchange.getRequest().getURI().getPath() + "请求时间为" + requestTime + "毫秒");
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
