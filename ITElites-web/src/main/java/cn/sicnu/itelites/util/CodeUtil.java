package cn.sicnu.itelites.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual",null);
        if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }

    public static String createMsgCode(HttpServletRequest request) {
        String msgCode = String.valueOf((int) (Math.random() * 1000000));
        request.getSession().setAttribute("msgCode", msgCode);
        return msgCode;
    }
}
