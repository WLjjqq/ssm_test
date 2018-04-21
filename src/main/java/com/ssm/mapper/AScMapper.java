package com.ssm.mapper;

import java.util.List;
import java.util.Map;

public interface AScMapper {
    List<Map<String,Object>> selectAvg();
    List<Map<String,Object>> selectMaxAndMin();
}
