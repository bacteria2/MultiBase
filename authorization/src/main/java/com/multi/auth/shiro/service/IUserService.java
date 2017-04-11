package com.multi.auth.shiro.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.multi.auth.shiro.EncryptionUtil;
import com.multi.common.util.SpringContextUtil;
import com.multi.data.relationdb.Status;
import com.multi.data.relationdb.user.MUser;
import com.multi.data.relationdb.user.dao.MUserMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */

public interface IUserService {

    int insertNewUser(MUser user,String creator);

    int updateUserInfo(MUser user,String modifier);

    int deleteUser(MUser user,String modifier);

    List<MUser> getUserWithPage(int page,int number);

    MUser login(String username,String password,String ip);

}
