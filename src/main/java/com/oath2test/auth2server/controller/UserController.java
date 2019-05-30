package com.oath2test.auth2server.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xixi
 * @since 2019-05-09
 */
@Controller
public class UserController {

    /**
     * 受保护资源
     * @param principal 认证主体
     * @return
     */
    @RequestMapping({ "/user" })
    @ResponseBody
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
}

