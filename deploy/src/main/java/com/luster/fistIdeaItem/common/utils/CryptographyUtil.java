package com.luster.fistIdeaItem.common.utils;

import com.luster.fistIdeaItem.common.utils.shiro.Digests;
import com.luster.fistIdeaItem.common.utils.shiro.Encodes;

/**
 * Created by dell on 2017-8-24.
 */
public class CryptographyUtil {
    private final static int saltSize=8;
    private final static int hashInterations=1024;

    /**
     * 加密密码(生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash)
     * @param password
     * @return
     */
    public  static  String entryptPassword(String password){
        String plain=Encodes.unescapeHtml(password);
        byte[] salt= Digests.generateSalt(saltSize);
        byte[] hashPassword=Digests.sha1(plain.getBytes(),salt,hashInterations);
        String saltStr=Encodes.encodeHex(salt);
        return  saltStr+Encodes.encodeHex(hashPassword);
    }

    public  static  String entryptPassword(String password,String saltStr){
        String plain=Encodes.unescapeHtml(password);
        byte[] salt= Encodes.decodeHex(saltStr);
        byte[] hashPassword=Digests.sha1(plain.getBytes(),salt,hashInterations);
        return  saltStr+Encodes.encodeHex(hashPassword);
    }

    public static void  main(String[] args)throws Exception{
        String password="maiqi";
        System.out.println(password);
        String entryptPassword=entryptPassword(password);
//        String entryptPassword="8c48d4d40eeab375fd60183e3781db28fe9a8834df8f0049cee6ac32";//maiqi
        System.out.println(entryptPassword);
//        String saltStr=entryptPassword.substring(0,16);
//        String newEntryptPwd=entryptPassword(password,saltStr);
//        System.out.println(newEntryptPwd);

    }
}
