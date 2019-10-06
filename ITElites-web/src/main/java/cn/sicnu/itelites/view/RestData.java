package cn.sicnu.itelites.view;

import cn.sicnu.itelites.dto.BaseExecution;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RestData extends RestView {

    public RestData(Object data) {
        this.error = 0;
        this.reason = "OK";
        this.data = data;
    }

    public RestData(BaseExecution<?> execution) {
        this.error = 0;
        this.reason = execution.getStateInfo();
        if (execution.getCount() == 1) {
            this.data = execution.getValue();
        }else {
            this.data = execution.getValueList();
        }
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONObject json = new JSONObject(true);
        json.put("error", error);
        json.put("reason", reason);
        if (data != null) {
            if (data instanceof JSON) {
                json.put("data", data);
            } else {
                json.put("data", JSON.toJSON(data));
            }
        }
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.getWriter().write(json.toJSONString());
    }
}
