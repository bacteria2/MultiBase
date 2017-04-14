package com.multi.auth;

import com.multi.auth.shiro.session.condition.RepoType;
import com.multi.auth.shiro.session.condition.SessionRepoType;
import com.multi.auth.shiro.session.condition.ShiroRepositoryCondition;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@Configuration
public class StorageConfiguration {
    @Value("${shiro.redis.host}") String host;
    @Value("${shiro.redis.port}")Integer port;

    @Bean(name="shiroRedis",autowire = Autowire.BY_NAME)
    @SessionRepoType(RepoType.Redis)
    @Conditional(ShiroRepositoryCondition.class)

    public JedisPool jedis(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setTestOnBorrow(true);

        config.setMaxTotal(500);
        config.setMaxIdle(40);
        config.setMinIdle(1);

        return new JedisPool(config,host,port);
    }

}
