package cn.sicnu.itelites.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    /**
     * 判断接收到的内容是否为空
     * @param params
     * @return
     */
    public static boolean checkIsEmpty(Map<String, String> params) {
        int count = 0; //用于计数
        Set<Map.Entry<String,String>> allSet = params.entrySet();
        Iterator<Map.Entry<String,String>> iterator = allSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> me = iterator.next();
            if (me.getValue().equals("")|| me.getValue().trim().equals("")) {
                count++;
            }
        }
        if(count > 0) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断收到的学号，电话和QQ是否符合规格
     * @param params
     * @return
     */
    public static boolean checkType(Map<String, String> params) {
        String stuNum = null;
        String stuPhone =null;
        String stuQq = null;
        int check = 0; //用于判断计数
        Set<Map.Entry<String,String>> allSet = params.entrySet();
        Iterator<Map.Entry<String,String>> iterator = allSet.iterator();

        //遍历获取学号电话和QQ信息
        while (iterator.hasNext()) {
            Map.Entry<String,String> me = iterator.next();
            if (me.getKey().equals("applicantNum")) {
                stuNum = me.getValue();
            }
            if (me.getKey().equals("phone")) {
                stuPhone = me.getValue();
            }
            if (me.getKey().equals("qq")) {
                stuQq = me.getValue();
            }
        }

        //对电话号码进行正则判断
        if (isPhone(stuPhone) || isMobile(stuPhone)){
            check++;
        }else {
           return false;
        }

        //对学号进行判断
        if (stuNum.trim().length() == 10 && stuNum.startsWith("2019")) {
            check++;
        }else {
            return false;
        }
        char[] stuNums = stuNum.trim().toCharArray();
        for (int i = 0; i < stuNums.length; i++) {
            if (stuNums[i] > '9' || stuNums[i] < '0') {
                return false;
            }
        }


        //对QQ进行判断
        char[] stuQqs = stuQq.trim().toCharArray();
        for (int i = 0; i < stuQqs.length; i++) {
            if (stuQqs[i] > '9' || stuQqs[i] < '0') {
                return false;
            }
        }

        if(check == 2) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 手机号验证
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
    /**
     * 电话号码验证
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(final String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");     // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }
}
