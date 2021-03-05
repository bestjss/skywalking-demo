package com.litchi.sw.servera.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Random;

/**
 * @Auther Litchi_duan
 * @Date 2021/3/5
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 非睡眠
     * @return
     */
    @GetMapping("/method-a")
    public String getMethodA(){
        return "this is Server A Method A";
    }

    /**
     * 指定睡眠
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/method-b/{sleep}")
    public String getMethodB(@PathVariable(name = "sleep")  Long sleep) throws InterruptedException {
        if(Objects.isNull(sleep)){
            sleep = 100l;
        }
        Thread.sleep(sleep);
        return "this is Server A Method B Sleep" + sleep;
    }

    /**
     * 随机随眠
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/method-c")
    public String getMethodC() throws InterruptedException {
        long sleep = 0l;
        Random rand = new Random();
        int start = 10;
        int end = 1000;
        sleep = rand.nextInt(end - start + 1) + start;
        Thread.sleep(sleep);
        return "this is Server A Method C Sleep " + sleep;
    }
}