package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dto.execution.MsgCodeExecution;
import cn.sicnu.itelites.enums.MsgCodeStateEnum;
import cn.sicnu.itelites.service.IMsgCodeService;
import cn.sicnu.itelites.util.CodeUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MsgCodeServiceImpl implements IMsgCodeService {

    @Override
    public MsgCodeExecution send(HttpServletRequest request) {
        String code =  CodeUtil.createMsgCode(request);
        //TODO

        if (code == null){
            return new MsgCodeExecution(MsgCodeStateEnum.CREATE_FAIL);
        }
        return new MsgCodeExecution(MsgCodeStateEnum.CREATE_SUCCESS);
    }

    @Override
    public MsgCodeExecution check(HttpServletRequest request) {
        String msgCode = (String) request.getSession().getAttribute("msgCode");
        if (msgCode == null || "".equals(msgCode)){
            return new MsgCodeExecution(MsgCodeStateEnum.GET_CODE);
        }

        String code = request.getParameter("code");
        if (code == null || "".equals(code) || code.length() != 6) {
            return new MsgCodeExecution(MsgCodeStateEnum.INVALID_CODE);
        }

        if (msgCode.equals(code)) {
            return new MsgCodeExecution(MsgCodeStateEnum.CHECK_SUCCESS);
        }
        return new MsgCodeExecution(MsgCodeStateEnum.CHECK_FAIL);
    }
}
