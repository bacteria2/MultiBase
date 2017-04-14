package com.multi.test.auth.shiro;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.multi.data.relationdb.Status;
import org.apache.shiro.codec.H64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import java.security.Key;
import java.util.Map;

import static com.multi.auth.shiro.EncryptionUtil.*;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public class ShiroUtilTest {

    @Test
    public void encryptTest(){
        String password = "admin";
        String cipherText = encrytHex(password);
        System.out.println(password + "hex加密之后的密文是：" + cipherText);
        String decrptPassword=decryptHex(cipherText);
        System.out.println(cipherText + "hex解密之后的密码是：" + decrptPassword);
        String cipherText_base64 = encrytBase64(password);
        System.out.println(password + "base64加密之后的密文是：" + cipherText_base64);
        String decrptPassword_base64=decryptBase64(cipherText_base64);
        System.out.println(cipherText_base64 + "base64解密之后的密码是：" + decrptPassword_base64);

        String h64=  H64.encodeToString(password.getBytes());
        System.out.println(h64);
        String salt="7road";
        String cipherText_md5= new Md5Hash(password,salt).toHex();
        System.out.println(password+"通过md5加密之后的密文是："+cipherText_md5);
        String cipherText_md5_base64= new Md5Hash(password,salt).toBase64();
        System.out.println(password+"通过md5加密之后的密文是："+cipherText_md5_base64);


        System.out.println(generateKey());
        System.out.println("==========================================================");
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key=aesCipherService.generateNewKey();

        String aes_cipherText= aesCipherService.encrypt(password.getBytes(),key.getEncoded()).toHex();
        System.out.println(password+" aes加密的密文是："+aes_cipherText);
        String aes_mingwen=new String(aesCipherService.decrypt(Hex.decode(aes_cipherText),key.getEncoded()).getBytes());
        System.out.println(aes_cipherText+" aes解密的明文是："+aes_mingwen);
    }

    @Test
    public void test(){
        byte a=1;

        System.out.println( Status.NORMAL);

    }

    @Test
    public void testJson(){
        Map<String,String> map=Maps.newHashMap();
        map.put("a","b");
      String a=  JSON.toJSONString(map) ;
        System.out.println(a);

        System.out.println(JSON.toJSONString(a));

    }
}
