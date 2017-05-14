package com.netease.server.example.dao;

import com.netease.server.example.meta.User;

/**
 *
 *
 * @author jiaozhihui@corp.netease.com
 */
public interface UserDao {
    public User getUserByAccount(User user);
}
