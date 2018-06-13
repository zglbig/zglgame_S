package org.zgl.utils.encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.rmi.server.UID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
public class Des {
   
    private final static String DES = "DES";  
       
    /** 
     * Description 根据键值进行加密 
     * @param data  
     * @param key  加密键byte数组 
     * @return 
     * @throws Exception 
     */  
    public static String encrypt(String data, String key) throws Exception {  
        byte[] bt = encrypt(data.getBytes(), key.getBytes());  
//        String strs = new BASE64Encoder().encode(bt);
        String str = Base64.getEncoder().encodeToString(bt);
        return str;
    }  
   
    /** 
     * Description 根据键值进行解密 
     * @param data 
     * @param key  加密键byte数组 
     * @return 
     * @throws IOException 
     * @throws Exception 
     */  
    public static String decrypt(String data, String key) throws IOException,
            Exception {  
        if (data == null)  
            return null;  
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] buf = decoder.decodeBuffer(data);
        byte[] buf = Base64.getDecoder().decode(data);
        byte[] bt = decrypt(buf,key.getBytes());  
        return new String(bt);  
    }  
   
    /** 
     * Description 根据键值进行加密 
     * @param data 
     * @param key  加密键byte数组 
     * @return 
     * @throws Exception 
     */  
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {  
        // 生成一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();
   
        // 从原始密钥数据创建DESKeySpec对象  
        DESKeySpec dks = new DESKeySpec(key);
   
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
   
        // Cipher对象实际完成加密操作  
        Cipher cipher = Cipher.getInstance(DES);
   
        // 用密钥初始化Cipher对象  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);  
   
        return cipher.doFinal(data);  
    }  
       
       
    /** 
     * Description 根据键值进行解密 
     * @param data 
     * @param key  加密键byte数组 
     * @return 
     * @throws Exception 
     */  
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {  
        // 生成一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();  
   
        // 从原始密钥数据创建DESKeySpec对象  
        DESKeySpec dks = new DESKeySpec(key);  
   
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);  
        SecretKey securekey = keyFactory.generateSecret(dks);  
   
        // Cipher对象实际完成解密操作  
        Cipher cipher = Cipher.getInstance(DES);  
   
        // 用密钥初始化Cipher对象  
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);  
   
        return cipher.doFinal(data);  
    }  
      
      
    /** 
     * Description 获取字符串MD5值 
     * @param sourceStr 
     */  
    private static String MD5(String sourceStr) {  
        String result = "";  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());  
            byte b[] = md.digest();  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            result = buf.toString();  
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }  
        return result;  
    }  
      
      
    public static void main(String[] args) throws Exception {  
        String data = "{devType:\"1\",Sys:\"01\",Name:\"张三\",PoId:\"000002\",TarPho:\"15527609770\",Desc:\"张三偷窃\"}";  
        String key = "12345678";//秘钥  
        String encode = encrypt(data, key);  
        System.err.println(encode);  
        String dcode = decrypt(encode, key);  
        System.err.println(dcode);
        System.out.println();
    }
}  