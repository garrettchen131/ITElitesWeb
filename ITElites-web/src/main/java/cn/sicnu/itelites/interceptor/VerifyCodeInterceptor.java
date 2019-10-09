package cn.sicnu.itelites.interceptor;

import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.view.RestError;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!CodeUtil.checkVerifyCode(request)){
            RestError error = new RestError("请填写正确的验证码!");
            error.render(null, request, response);
            return false;
        }
        return true;
    }
}
