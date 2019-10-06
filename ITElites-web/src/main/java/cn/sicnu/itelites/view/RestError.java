package cn.sicnu.itelites.view;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.exception.OperationException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RestError extends RestView{

    public RestError() {
    }

    public RestError(int error) {
        this.error = error;
        this.reason = "not know error";
    }

    public RestError(String reason) {
        this.error = -1;
        this.reason = reason;
    }

    public RestError(int error, String reason) {
        this.error = error;
        this.reason = reason;
    }

    public RestError(BaseExecution<?> execution) {
        this.error = execution.getState();
        this.reason = execution.getStateInfo();
    }

    public RestError(OperationException e) {
        this.error = e.getError();
        this.reason = e.getMessage();
        if(this.reason == null)
            this.reason = e.getClass().getName();
    }

    public RestError(RuntimeException e) {
        this.reason = e.getMessage();
        if(this.reason == null)
            this.reason = e.getClass().getName();
    }

    public RestError(Exception e) {
        this.reason = e.getMessage();
        if(this.reason == null)
            this.reason = e.getClass().getName();
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject json = new JSONObject(true);
        json.put("error", error);
        json.put("reason", reason);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.getWriter().write(json.toJSONString());
    }
}
