package com.multi.auth.shiro.session.condition;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
public enum RepoType {
    Redis("redis"),EhCache("ehcache");

    private String type;

    RepoType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
