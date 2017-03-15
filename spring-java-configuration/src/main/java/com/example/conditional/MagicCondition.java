package com.example.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * Created by anil on 3/7/17.
 */
public class MagicCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();
        System.out.println(annotatedTypeMetadata.isAnnotated(Bean.class.getName()));
        MultiValueMap<String, Object> attr = annotatedTypeMetadata.getAllAnnotationAttributes(Bean.class.getName(), true);
        for (String key : attr.keySet()) {
            for (Object value : attr.get(key)) {
                System.out.println(key + ":" + value);
            }
        }
        return true;
    }
}
