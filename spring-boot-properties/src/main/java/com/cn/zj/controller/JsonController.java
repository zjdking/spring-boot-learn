package com.cn.zj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

/**
 * 加载resource下边的 json  文件；
 *
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@RestController
public class JsonController {
    @RequestMapping("/getDic")
    public JSONObject getDictionary(@RequestParam String name) throws IOException {
        JSONObject json = null;
        InputStream config = getClass().getResourceAsStream("/dictionary/"+name+".json");
        if (config == null) {
            throw new RuntimeException("读取文件失败");
        } else {
            json = JSON.parseObject(config, JSONObject.class);
        }
        return json;
    }
}
