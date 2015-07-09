package org.creditease.cn.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.SystemException;

public class DateUitils {
	 /**
     * 得到字符串格式的当前日期时间(yyyy-MM-dd HH:mm:ss)。
     * @return
     * @throws SystemException
     */
    public static String getNowDatetime() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }
    /**
     * 得到字符串格式的当前Timestamp。
     * @return
     * @throws SystemException
     */
    public static Timestamp getNowDatetimestamp(Date date) throws SystemException {
    	
    	SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        //Date date = new Date();  
        String time = df1.format(date);  
        Timestamp ts = Timestamp.valueOf(time);
        
        return ts;
    }
    
    

    /**
     * 得到字符串格式的当前日期(yyyy-MM-dd)。
     * @return
     * @throws SystemException
     */
    public static String getNowDate() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyy-MM-dd");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的当前时间(HH:mm:ss)。
     * @return
     * @throws SystemException
     */
    public static String getNowTime() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("HH:mm:ss");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的当前日期时间(yyyyMMddHHmmss)。
     * @return
     * @throws SystemException
     */
    public static String getNowCompactDatetime() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的当前日期(yyyyMMdd)。
     * @return
     * @throws SystemException
     */
    public static String getNowCompactDate() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyyMMdd");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的当前时间(HHmmss)。
     * @return
     * @throws SystemException
     */
    public static String getNowCompactTime() throws SystemException {
        String strDate = null;

        try {
            SimpleDateFormat dsdFormat = new SimpleDateFormat("HHmmss");
            strDate = dsdFormat.format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的日期时间(yyyy-MM-dd HH:mm:ss)。
     * @return
     * @throws SystemException
     */
    public static String getDatetime(Date date){
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    public static Date parseDatetime(String strDate) throws SystemException {
        Date date = null;
        if (strDate != null) {
            try {
                SimpleDateFormat sdFormat = null;
                if (strDate.length() == 8) {
                    sdFormat = new SimpleDateFormat("yyyyMMdd");
                } else if (strDate.length() == 10 && strDate.indexOf("-") >= 0) {
                    sdFormat = new SimpleDateFormat("yyyy-MM-dd");
                } else if (strDate.length() == 10 && strDate.indexOf("/") >= 0) {
                    sdFormat = new SimpleDateFormat("yyyy/MM/dd");
                } else if (strDate.length() == 14) {
                    sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                } else if (strDate.length() == 19 && strDate.indexOf("/") >= 0) {
                    sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                } else { //else if (strValue.length() == 19 && strValue.indexOf("-") >= 0) {
                    sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }
                date = sdFormat.parse(strDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 得到字符串格式的日期(yyyy-MM-dd)。
     * @return
     * @throws SystemException
     */
    public static String getDate(Date date) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyy-MM-dd");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的时间(HH:mm:ss)。
     * @return
     * @throws SystemException
     */
    public static String getTime(Date date) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("HH:mm:ss");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的日期。
     * @return
     * @throws SystemException
     */
    public static String getDate(Date date,String dateFormat) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat(dateFormat);
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }
    /**
     * 得到字符串格式的日期时间(yyyyMMddHHmmss)。
     * @return
     * @throws SystemException
     */
    public static String getCompactDatetime(Date date) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的日期(yyyyMMdd)。
     * @return
     * @throws SystemException
     */
    public static String getCompactDate(Date date) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("yyyyMMdd");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
        	
            ex.printStackTrace();
        }

        return strDate;
    }

    /**
     * 得到字符串格式的时间(HHmmss)。
     * @return
     * @throws SystemException
     */
    public static String getCompactTime(Date date) throws SystemException {
        String strDate = null;

        try {
            if (date != null) {
                SimpleDateFormat dsdFormat = new SimpleDateFormat("HHmmss");
                strDate = dsdFormat.format(date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return strDate;
    }

    public static Date calcDate(Date date, int day) {
        if (date == null) {
            date = new Date();
        }
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.DATE, day);
        return cale.getTime();
    }

    public static Date calcDate(Date date, int field, int amount) {
        if (date == null) {
            date = new Date();
        }
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(field, amount);
        return cale.getTime();
    }

    public static Date calcNowDate(int day) {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.DAY_OF_YEAR, day);
        return cale.getTime();
    }

    public static Date calcNowDate(int field, int amount) {
        Calendar cale = Calendar.getInstance();
        cale.add(field, amount);
        return cale.getTime();
    }

    /**
     * 得到主机的IPs
     * @return
     * @throws SystemException
     */
    public static String getHostIPs() throws SystemException {
        StringBuffer sb = new StringBuffer();

        try {
            InetAddress[] ia = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
            if (ia != null && ia.length > 0) {
                for (int i = 0; i < ia.length; i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append(ia[i].getHostAddress());
                }
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 分割连接字符串
     * @param ljzfc - 连接字符串
     * @param key - Key
     * @param separator - 分割符号
     * @return
     */
    public static String split(String ljzfc, String key, String separator) {
        String str = null;

        if (ljzfc != null && key != null && ljzfc.length() > key.length()) {
            int ii = ljzfc.indexOf(key);
            if (ii >= 0) {
                int li = ljzfc.indexOf(separator, ii);
                if (li > 0) {
                    str = ljzfc.substring(ii, li);
                } else {
                    str = ljzfc.substring(ii);
                }
                str = str.substring(key.length());
            }
        }

        return str;
    }

    /**
     * 字符串替换（无正规表达式）
     * @param str - 字符串
     * @param str1 - 需替换的字符串
     * @param str2 - 替换成的字符串
     * @return String
     */
    public static String replace(String str, String str1, String str2) {

        str2 = str2 == null ? "" : str2;
        if (str == null || str1 == null) {
            return str;
        }

        List lst = new ArrayList();
        int i = 0;
        do {
            i = str.indexOf(str1, i);
            if (i < 0) {
                break;
            }
            if (i > 0) {
                lst.add(str.substring(0, i));
            }
            lst.add(str2); ;
            str = str.substring(i + str1.length());
            i = 1;
        } while (true);
        lst.add(str);

        StringBuffer sb = new StringBuffer(512);
        for (int l = 0; l < lst.size(); l++) {
            sb.append((String) lst.get(l));
        }

        return sb.toString();
    }

    /**
     * 移去字符串左边的空格
     * @param str - 字符串
     * @return
     */
    public static String LTrim(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        char[] val = str.toCharArray();
        int st = 0;
        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }

        return str.substring(st, len);
    }

    /**
     * 移去字符串右边的空格
     * @param str - 字符串
     * @return
     */
    public static String RTrim(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        char[] val = str.toCharArray();
        while (len > 0 && val[len - 1] <= ' ') {
            len--;
        }

        return str.substring(0, len);
    }

    /**
     * 替换多个空格成单个空格。
     * @param str String
     * @return String
     */
    public static String ReplaceMultiToOneSpace(String str) {
        String str1;
        do {
            str1 = str;
            str = str.replaceAll("  ", " ");
        } while (!str.equals(str1));
        return str1;
    }
    
    /**
     * 转换成float类型
     * @param str String
     * @return float
     */
    public static float ConvertToFloat(String str) {        
        return Float.parseFloat(str);
    }
}
