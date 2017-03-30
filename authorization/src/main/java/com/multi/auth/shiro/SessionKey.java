package com.multi.auth.shiro;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
public enum SessionKey {
    RedisSessionKey("shiro_session_%s");

    private String keyPrefix;

    SessionKey(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public String getKey(String... key){
        return String.format(keyPrefix, (Object[]) key);
    }
}
