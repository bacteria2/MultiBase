package com.multi.auth.shiro;

import com.google.common.base.Preconditions;
import com.multi.auth.shiro.session.ISessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description redis SessionDAO
 */

public class CustomSessionDAO extends AbstractSessionDAO {

    @Autowired
    ISessionRepository sessionRepository;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        sessionRepository.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return sessionRepository.getSession(sessionId);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        sessionRepository.saveSession(session);
    }

    @Override
    public void delete(Session session) {
        Preconditions.checkNotNull(session,"session can not be null");
        Preconditions.checkNotNull(session.getId(),"session id can not be null");
        sessionRepository.deleteSession(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return sessionRepository.getAllSessions();
    }
}
