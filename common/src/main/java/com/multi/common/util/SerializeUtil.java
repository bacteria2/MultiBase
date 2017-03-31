package com.multi.common.util;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author shepard.xia
 * @date 2017年03月31日
 * @description input useage
 */
public class SerializeUtil {
    private static Logger log = LoggerFactory.getLogger(SerializeUtil.class);


    public static byte[] serialize(Object obj) {
        Preconditions.checkNotNull(obj, "serialize objecte can't be null");
        byte[] outBytes = new byte[0];
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(obj);
            byteArrayOutputStream.flush();
            outBytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("对象序列化错误", e);
        }
        return outBytes;
    }

    public static Object deSerialize(byte[] bytes){
        return  deSerialize(bytes, Object.class);
    }

    public static <T> T deSerialize(byte[] bytes,Class<T> clazz) {
        Preconditions.checkNotNull(bytes, "deSerialize bytes can't be null");
        Object obj=new Object();

        try (ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes); ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream)){
            obj=objectInputStream.readObject();

        } catch (IOException|ClassNotFoundException e) {
            log.error("对象序列化错误", e);
        }
        return (T)obj;

    }


}
