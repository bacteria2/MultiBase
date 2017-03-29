package com.multi.auth.shiro.session.condition;

import java.lang.annotation.*;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionRepoType {
    RepoType value() default RepoType.EhCache;
}
