package com.ssm.service;

import java.util.List;
import java.util.Map;

public interface AScService {
    List<Map<String,Object>> queryAvg();
    List<Map<String,Object>> queryMaxAndMin();
}
