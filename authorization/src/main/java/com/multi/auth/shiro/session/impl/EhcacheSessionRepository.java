package com.multi.auth.shiro.session.impl;

import com.multi.auth.shiro.session.ISessionRepository;
import com.multi.auth.shiro.session.condition.RepoType;
import com.multi.auth.shiro.session.condition.SessionRepoType;
import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@SessionRepoType(RepoType.EhCache)
public class EhcacheSessionRepository implements ISessionRepository {
    @Override
    public void saveSession(Session session) {

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
