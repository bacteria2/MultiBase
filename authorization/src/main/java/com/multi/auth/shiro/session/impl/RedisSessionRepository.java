/*
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
import com.multi.common.util.SerializeUtil;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

*/
/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 *//*

@Component
@Conditional(ShiroRepositoryCondition.class)
@SessionRepoType(RepoType.Redis)
public class RedisSessionRepository implements ISessionRepository {

    private Logger log = LoggerFactory.getLogger(RedisSessionRepository.class);

    @Autowired
    @Qualifier("shiroRedis")
    JedisPool jedisPool;

    private static final int SESSION_VAL_TIME_SPAN = 18000;

    private String sessionKey;


    @Override
    public void saveSession(Session session) {
        Preconditions.checkNotNull(session, "session can not be null");

        //不存在才添加。
        if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
            //Session 踢出自存存储。
            SessionStatus sessionStatus = new SessionStatus();
            log.info("踢出cookie{}", sessionStatus);
            session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
        }

        byte[] key = SessionKey.RedisSessionKey.getKey(session.getId().toString()).getBytes();

        Long expireTime = session.getTimeout() / 1000 + SESSION_VAL_TIME_SPAN + (5 * 60);

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, SerializeUtil.serialize(session));
            jedis.expire(key, expireTime.intValue());
        }


    }

    @Override
    public void deleteSession(Serializable sessionId) {
        Preconditions.checkNotNull(sessionId, "sessionId can not be null");
        byte[] key = SessionKey.RedisSessionKey.getKey(sessionId.toString()).getBytes();
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(key);
        }
    }

    @Override
    public Session getSession(Serializable sessionId) {
        Preconditions.checkNotNull(sessionId, "sessionId can not be null");
        byte[] key = SessionKey.RedisSessionKey.getKey(sessionId.toString()).getBytes();
        try (Jedis jedis = jedisPool.getResource()) {
            return SerializeUtil.deSerialize(jedis.get(key), Session.class);
        }

    }

    */
/**
     * keys命令可能会导致性能问题,需考虑是否有替代方案或者该方法使用频率
     *//*

    @Override
    public Collection<Session> getAllSessions() {
        Set<Session> sessions = new HashSet<>();
        try (Jedis jedis = jedisPool.getResource()) {
            Set<byte[]> byteKeys = jedis.keys((SessionKey.RedisSessionKey.getKey("*")).getBytes());
            if (byteKeys != null && byteKeys.size() > 0) {
                for (byte[] key : byteKeys) {
                    Session obj = SerializeUtil.deSerialize(jedis.get(key), Session.class);
                    sessions.add(obj);
                }
            }
            return sessions;
        }

    }
}
*/
