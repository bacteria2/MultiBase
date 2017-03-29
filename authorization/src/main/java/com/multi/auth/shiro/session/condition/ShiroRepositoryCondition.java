package com.multi.auth.shiro.session.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Optional;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */

public class ShiroRepositoryCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(context.getEnvironment()!=null){
            String type= Optional.ofNullable(context.getEnvironment().getProperty("shiro.repository.type")).orElse("ehCache                            ");
            Map<String,Object> attr = metadata.getAnnotationAttributes(SessionRepoType.class.getName());
            if (attr!=null){
                RepoType repo=(RepoType)attr.get("value");
                if(type.equals(repo.getType()))
                    return true;
            }
        }

        return false;
    }
}
