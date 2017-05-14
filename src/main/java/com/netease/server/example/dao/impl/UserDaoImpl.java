package com.netease.server.example.dao.impl;

import com.netease.server.example.dao.UserDao;
import com.netease.server.example.meta.User;

/**
 *
 *
 * @author jiaozhihui@corp.netease.com
 */
public class UserDaoImpl implements UserDao {
    public User getUserByAccount(User user) {
        if (user.getUserName().equals("server") && user.getUserPassword().equals("123")) {
            user.setUserDesc("Test user for example server");
            return user;
        }

        return null;
    }
}
