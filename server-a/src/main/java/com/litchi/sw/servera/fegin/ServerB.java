package com.litchi.sw.servera.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;
import java.util.Random;

/**
 * @Auther Litchi_duan
 * @Date 2021/3/6
 * @Description
 */
@FeignClient(value = "service-b", url = "${fegin.b.host}")
public interface ServerB {

    /**
     * 非睡眠
     *
     * @return
     */
    @GetMapping("/test/method-a")
    String getMethodA();

    /**
     * 指定睡眠
     *
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/test/method-b/{sleep}")
    String getMethodB(@PathVariable(name = "sleep") Long sleep);

    /**
     * 随机随眠
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/test/method-c")
    String getMethodC() throws InterruptedException;
}