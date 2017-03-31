package com.multi.auth.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * @author shepard.xia
 * @date 2017年03月31日
 * @description input useage
 */
public class CustomeShiroCacheManager implements CacheManager,Destroyable {
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }
}
