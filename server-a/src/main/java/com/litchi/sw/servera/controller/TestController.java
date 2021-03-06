package com.litchi.sw.servera.controller;

import com.litchi.sw.servera.fegin.ServerB;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ServerB serverB;

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

    /**
     * 非睡眠
     * @return
     */
    @GetMapping("/b/method-a")
    public String getMethodBA(){
        return serverB.getMethodA();
    }

    /**
     * 指定睡眠
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/b/method-b/{sleep}")
    public String getMethodBB(@PathVariable(name = "sleep")  Long sleep) throws InterruptedException {
       return serverB.getMethodB(sleep);
    }

    /**
     * 随机随眠
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/b/method-c")
    public String getMethodBC() throws InterruptedException {
        return serverB.getMethodC();
    }

    /**
     * 非睡眠
     * @return
     */
    @GetMapping("/c/b/method-a")
    public String getMethodCBA(){
        return serverB.getMethodBCA();
    }

    /**
     * 指定睡眠
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/c/b/method-b/{sleep}")
    public String getMethodCBB(@PathVariable(name = "sleep")  Long sleep) throws InterruptedException {
        return serverB.getMethodBCB(sleep);
    }

    /**
     * 随机随眠
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/c/b/method-c")
    public String getMethodCBC() throws InterruptedException {
        return serverB.getMethodBCC();
    }
}