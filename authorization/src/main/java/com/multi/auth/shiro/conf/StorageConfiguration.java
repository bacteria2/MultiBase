package com.multi.auth.shiro.conf;

import com.multi.auth.shiro.session.condition.RepoType;
import com.multi.auth.shiro.session.condition.SessionRepoType;
import com.multi.auth.shiro.session.condition.ShiroRepositoryCondition;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@Configuration
public class StorageConfiguration {

    @Bean(name="shiroJedis",autowire = Autowire.BY_NAME)
    @SessionRepoType(RepoType.Redis)
    @Conditional(ShiroRepositoryCondition.class)
    public Jedis jedis(@Value("${shiro.redis.host}") String host,@Value("${shiro.redis.port}")Integer port){
        return new Jedis(host,port);
    }

}
