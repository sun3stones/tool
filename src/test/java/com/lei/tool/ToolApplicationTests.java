package com.lei.tool;

import com.lei.tool.mapper.UUserMapper;
import com.lei.tool.utils.ssh.DeployService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToolApplicationTests {

    @Autowired
    private UUserMapper userMapper;
    @Autowired
    private DeployService deployService;

    @Test
    public void contextLoads() {
        userMapper.selectAll();
        userMapper.getUserCount();
    }

    @Test
    public void getStatus(){
        System.out.println(deployService.getStatus(""));

    }
    @Test
    public void stop(){
        deployService.stop();

    }

}
