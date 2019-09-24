package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.execution.FirstHeadExecution;
import org.springframework.transaction.annotation.Transactional;


public interface IFirstHeadService {
    @Transactional(readOnly = true)
    public FirstHeadExecution getAllFirstHead();
}