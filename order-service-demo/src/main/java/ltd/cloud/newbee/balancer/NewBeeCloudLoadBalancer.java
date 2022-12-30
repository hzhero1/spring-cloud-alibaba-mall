package ltd.cloud.newbee.balancer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NewBeeCloudLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    private String serviceName;

    public NewBeeCloudLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceName) {
        this.serviceName = serviceName;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }

    private AtomicInteger atomicCount = new AtomicInteger(0);

    private AtomicInteger atomicCurrentIndex = new AtomicInteger(0);

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable();
        return supplier.get().next().map(this::getInstanceResponse);
    }


    /**
     * 使用自定义方法获取服务
     *
     * @param instances
     * @return
     */
    private Response<ServiceInstance> getInstanceResponse(
            List<ServiceInstance> instances) {
        ServiceInstance serviceInstance = null;

        if (instances.isEmpty()) {
            System.out.println("注册中心无可用实例:" + serviceName);
            return new EmptyResponse();
        }

        // 累加并得到值 请求次数
        int requestNumber = atomicCount.incrementAndGet();

        //自定义算法
        serviceInstance = instances.get(atomicCurrentIndex.get() % instances.size());
        if(requestNumber >= 2){
            // 已经大于2了 重置
            atomicCount = new AtomicInteger(0);
            // atomicCurrentIndex变量加1
            atomicCurrentIndex.incrementAndGet();
        }
        return new DefaultResponse(serviceInstance);
    }

    @Override
    public Mono<Response<ServiceInstance>> choose() {
        return ReactorServiceInstanceLoadBalancer.super.choose();
    }
}
