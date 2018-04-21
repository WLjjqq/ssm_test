package com.ssm.service.impl;

import com.ssm.exception.NoException;
import com.ssm.mapper.AScMapper;
import com.ssm.service.AScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AScServiceImpl implements AScService {
    @Autowired
    private AScMapper aScMapper;
    @Override
    public List<Map<String, Object>> queryAvg() {
        try {
            List<Map<String,Object>> list = aScMapper.selectMaxAndMin();
            return list;
        }catch (NoException ne){
            throw ne;
        }
    }

    @Override
    public List<Map<String, Object>> queryMaxAndMin() {
        return null;
    }
}
