package com.multi.auth.shiro;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.multi.data.relationdb.user.MUser;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.Key;


/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public class EncryptionUtil {

    /**
     * base64进制加密
     *
     * @param password
     * @return
     */
    public static String encrytBase64(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
        byte[] bytes = password.getBytes();
        return Base64.encodeToString(bytes);
    }
    /**
     * base64进制解密
     * @param cipherText
     * @return
     */
    public static String decryptBase64(String cipherText) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
        return Base64.decodeToString(cipherText);
    }
    /**
     * 16进制加密
     *
     * @param password
     * @return
     */
    public static String encrytHex(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
        byte[] bytes = password.getBytes();
        return Hex.encodeToString(bytes);
    }
    /**
     * 16进制解密
     * @param cipherText
     * @return
     */
    public static String decryptHex(String cipherText) {

        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
        return new String(Hex.decode(cipherText));
    }
    public static String generateKey()
    {
        AesCipherService aesCipherService=new AesCipherService();
        Key key=aesCipherService.generateNewKey();
        return Base64.encodeToString(key.getEncoded());
    }

    /**
     * 对密码进行md5加密,并返回密文和salt，
     * @param user 用户model
     * @return 密码和salt
     */
    public static MUser md5Password(MUser user){
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getUsername()),"username不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getPassword()),"password不能为空");
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
        String salt= secureRandomNumberGenerator.nextBytes().toHex();
        String password_cipherText=md5Password(user.getUsername(),user.getPassword(),salt);
        user.setPassword(password_cipherText);
        user.setSalt(salt);
        return user;
    }

    /**
     * 对密码进行md5加密
     * @param username 用户名
     * @param password 密码
     * @return 密文和salt
     */
    public static String md5Password(String username,String password,String salt){
        Preconditions.checkArgument(!Strings.isNullOrEmpty(username),"username不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password),"password不能为空");
        //组合username,两次迭代，对密码进行加密
        return new Md5Hash(password,username+salt,2).toBase64();
    }
}
