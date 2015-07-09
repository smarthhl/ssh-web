package org.creditease.cn.utils;
import java.security.MessageDigest;
public class MD5Util {
    /*** 
     * MD5 32bit
     * @param 
     * @return 
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**5f1d7a84db00d2fce00b31a7fc73224f
     * test function
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("123456");
        System.out.println("before：" + str);
        System.out.println("MD5 after：" +md5Encode(md5Encode(str)+"123456"));
    }
}