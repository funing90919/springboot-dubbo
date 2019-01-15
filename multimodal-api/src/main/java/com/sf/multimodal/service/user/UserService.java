package com.sf.multimodal.service.user;

import com.sf.multimodal.domain.UserDO;

import java.util.List;

/**
 * Created by Jacky on 2019/1/8 16:42.
 */
public interface UserService {

    List<UserDO> findUserList();

    UserDO findUserById(Integer id);
}
