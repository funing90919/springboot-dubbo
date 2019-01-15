package com.sf.multimodal;

import com.sf.multimodal.domain.UserDO;
import com.sf.multimodal.service.user.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultimodalUserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        List<UserDO> userList = userService.findUserList();
        System.out.println(userList);
    }

}

