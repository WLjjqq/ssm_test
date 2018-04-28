package com.ssm.utils;

import com.ssm.enums.BaseCodeEnum;

/**
 * 将数值转换为枚举实例
 */
public class CodeEnumUtil {
    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code)
                return e;
        }
        return null;
    }
}
