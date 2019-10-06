package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.execution.MsgCodeExecution;

import javax.servlet.http.HttpServletRequest;

public interface IMsgCodeService {

    public MsgCodeExecution send(HttpServletRequest request);

    public MsgCodeExecution check(HttpServletRequest request);
}
