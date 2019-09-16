package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.IFirstHeadDAO;
import cn.sicnu.itelites.dto.FirstHeadDTO;
import cn.sicnu.itelites.entity.FirstHead;
import cn.sicnu.itelites.service.IFirstHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirstHeadServiceImpl implements IFirstHeadService
{
    @Autowired
    private IFirstHeadDAO firstHeadDAO;
    @Override
    public List<FirstHeadDTO> getAllFirstHead()
    {
        List<FirstHead> firstHeadList = firstHeadDAO.queryAllFirstHead();
        List<FirstHeadDTO> dtoList = new ArrayList<>();
        firstHeadList.forEach(e->{
            dtoList.add(new FirstHeadDTO(e.getFirstHeadId(),e.getFirstHeadName(),e.getFirstHeadUrl(),e.getPriority()));
        });
        return dtoList;
    }
}
