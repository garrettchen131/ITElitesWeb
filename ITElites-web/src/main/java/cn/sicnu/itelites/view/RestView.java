package cn.sicnu.itelites.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class RestView implements View {

    protected int error;
    protected String reason;
    protected Object data;

}
