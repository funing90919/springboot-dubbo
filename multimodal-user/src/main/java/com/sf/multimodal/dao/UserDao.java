package com.sf.multimodal.dao;

import com.sf.multimodal.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jacky on 2019/1/7 17:15
 */

@Mapper
public interface UserDao {

    List<UserDO> findUserList();

    UserDO findUserById(Integer id);
}
