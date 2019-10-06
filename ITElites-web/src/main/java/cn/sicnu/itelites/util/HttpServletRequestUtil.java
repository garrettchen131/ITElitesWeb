package cn.sicnu.itelites.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key, Integer defValue) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            if (defValue != null)
                return defValue;
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key, Long defValue) {
        try {
            return Long.decode(request.getParameter(key));
        } catch (Exception e) {
            if (defValue != null)
                return defValue;
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request, String key, Double defValue) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            if (defValue != null)
                return defValue;
            return -1;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key, Boolean defValue) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            if (defValue != null)
                return defValue;
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key, String defValue) {
        try {
            String ret = request.getParameter(key);
            if ("".equals(ret)) {
                ret = null;
            }
            if (ret != null) {
                ret = ret.trim();
            }
            return ret;
        } catch (Exception e) {
            if (defValue != null)
                return defValue;
            return null;
        }
    }
}
