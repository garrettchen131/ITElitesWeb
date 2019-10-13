package cn.sicnu.itelites.view;

import org.springframework.web.servlet.View;

public abstract class RestView implements View {

    protected int error;
    protected String reason;
    protected Object data;

}
