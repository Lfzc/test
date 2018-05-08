package com.example.demotest;

import com.example.demotest.demo.DemoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/5/2 17:36
 * @desc .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class QuartzTest {

    @Resource
    private DemoController demoController;

    @Test
    public void test1(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demoController.setCron("0/10 * * * * ?");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
