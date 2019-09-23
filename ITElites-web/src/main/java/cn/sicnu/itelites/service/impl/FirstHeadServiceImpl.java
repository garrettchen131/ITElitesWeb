package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.IFirstHeadDAO;
import cn.sicnu.itelites.dto.FirstHeadExecution;
import cn.sicnu.itelites.enums.FirstHeadStateEnum;
import cn.sicnu.itelites.service.IFirstHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FirstHeadServiceImpl implements IFirstHeadService {
    @Autowired
    private IFirstHeadDAO firstHeadDAO;

    @Override
    public FirstHeadExecution getAllFirstHead() {
        return new FirstHeadExecution(FirstHeadStateEnum.SUCCESS,firstHeadDAO.queryAllFirstHead());
    }
}
