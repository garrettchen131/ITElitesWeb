package cn.sicnu.itelites.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RestData implements View {
    private Object data;

    public RestData(Object data) {
        this.data = data;
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("error", 0);
        jsonObject.put("reason", "OK");
        if (data != null) {
            if (data instanceof JSON) {
                jsonObject.put("data", data);
            } else {
                jsonObject.put("data", JSON.toJSON(data));
            }
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().write(jsonObject.toJSONString());
        }
    }
}
