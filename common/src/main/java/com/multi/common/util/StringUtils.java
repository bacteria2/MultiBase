package com.multi.common.util;


import java.util.Set;
import java.util.TreeSet;

/**
 * @author shepard.xia
 * @date 2017年03月29日
 * @description input useage
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static Set<?> array2Set(Object... objects){
        Set<Object> set = new TreeSet<>();
        for (Object id : objects) {
            if(null != id){
                set.add(id);
            }
        }
        return set;
    }

}
