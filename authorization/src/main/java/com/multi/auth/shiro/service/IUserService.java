package com.multi.auth.shiro.service;

import com.multi.data.model.UUser;

import java.sql.Date;
import java.time.Instant;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */

public interface IUserService {


    default public UUser login(String userName, String password) {
        return new UUser(12345L, "test", "test@email.com", "pwsd",
                Date.from(Instant.now()), Date.from(Instant.now()), 1L);
    }
}
