package com.multi.auth.shiro.session.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.multi.auth.shiro.SessionKey;
import com.multi.auth.shiro.session.CustomSessionManager;
import com.multi.auth.shiro.session.ISessionRepository;
import com.multi.auth.shiro.session.SessionStatus;
import com.multi.auth.shiro.session.condition.RepoType;
import com.multi.auth.shiro.session.condition.SessionRepoType;
import com.multi.auth.shiro.session.condition.ShiroRepositoryCondition;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@Repository
@Conditional(ShiroRepositoryCondition.class)
@SessionRepoType(RepoType.Redis)
public class RedisSessionRepository implements ISessionRepository {

    private Logger log= LoggerFactory.getLogger(RedisSessionRepository.class);

    @Autowired
    @Qualifier("shiroRedis")
    Jedis jedis;

    private static final int SESSION_VAL_TIME_SPAN = 18000;

    private String sessionKey;


    @Override
    public void saveSession(Session session) {
        Preconditions.checkNotNull(session,"session can not be null");

        //不存在才添加。
        if(null == session.getAttribute(CustomSessionManager.SESSION_STATUS)){
            //Session 踢出自存存储。
            SessionStatus sessionStatus = new SessionStatus();
            log.info("踢出cookie{}",sessionStatus);
            session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
        }

        String key=SessionKey.RedisSessionKey.getKey(session.getId().toString());
        Long expireTime = session.getTimeout()/1000 + SESSION_VAL_TIME_SPAN + (5 * 60);
        jedis.set(key, JSON.toJSONString(session));
        jedis.expire(key,expireTime.intValue());

    }

    @Override
    public void deleteSession(Serializable sessionId) {

    }

    @Override
    public Session getSession(Serializable sessionId) {
        return null;
    }

    @Override
    public Collection<Session> getAllSessions() {
        return null;
    }
}
