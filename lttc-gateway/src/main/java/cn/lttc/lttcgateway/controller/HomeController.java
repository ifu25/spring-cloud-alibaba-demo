package cn.lttc.lttcgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 主页控制器
 *
 * @author xinggang
 * @create 2022-03-06
 */
@RestController
public class HomeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public Object index() {
        return discoveryClient.getInstances("lttc-system");
    }

    /**
     * 用户列表
     *
     * @return java.lang.Object
     * @author xinggang
     * @create 2022-03-06
     **/
    @RequestMapping("/userList")
    public Object userList() {

        //获取服务实例
        ServiceInstance serviceInstance = discoveryClient.getInstances("lttc-system").get(0);
        String url = serviceInstance.getUri().toString();

        //请求服务
        return restTemplate.getForObject(url + "/userList", String.class);
    }
}
