package cn.lttc.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 用户 控制器
 *
 * @author xinggang
 * @create 2022-03-06
 */
@RestController
public class UserController {

    /**
     * 用户列表
     *
     * @return java.lang.Object
     * @author xinggang
     * @create 2022-03-06
     **/
    @RequestMapping("/userList")
    public Object userList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "张三");
        map.put("002", "李四");
        map.put("003", "王五");
        return map;
    }
}
