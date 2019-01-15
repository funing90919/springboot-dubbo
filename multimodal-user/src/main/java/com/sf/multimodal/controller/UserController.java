package com.sf.multimodal.controller;

import com.sf.multimodal.domain.UserDO;
import com.sf.multimodal.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jacky on 2019/1/7 17:18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDO> findUserList() {
        return userService.findUserList();
    }
}
