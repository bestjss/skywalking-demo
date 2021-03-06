package com.litchi.sw.serverb.controller;

import com.litchi.sw.serverb.fegin.ServerC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private ServerC serverC;

    /**
     * 非睡眠
     * @return
     */
    @GetMapping("/method-a")
    public String getMethodA(){
        return "this is Server B Method A";
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
        return "this is Server B Method B Sleep" + sleep;
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
        return "this is Server B Method C Sleep " + sleep;
    }

    /**
     * 非睡眠
     * @return
     */
    @GetMapping("/c/method-a")
    public String getMethodCA(){
        return serverC.getMethodA();
    }

    /**
     * 指定睡眠
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/c/method-b/{sleep}")
    public String getMethodCB(@PathVariable(name = "sleep")  Long sleep) throws InterruptedException {
        return serverC.getMethodB(sleep);
    }

    /**
     * 随机随眠
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/c/method-c")
    public String getMethodCC() throws InterruptedException {
        return serverC.getMethodC();
    }
}