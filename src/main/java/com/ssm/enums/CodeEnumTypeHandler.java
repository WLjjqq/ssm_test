package com.ssm.enums;

import com.ssm.utils.CodeEnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeEnumTypeHandler<E extends Enum<?> & BaseCodeEnum> extends BaseTypeHandler<BaseCodeEnum> {

    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     *   保存的时候，传入的是：ComputerState.OPEN   保存到数据库的是：10
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseCodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     *
     *       数据库中是10  输出的值是：OPEN
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public BaseCodeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return rs.wasNull() ? null : codeOf(code);
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     *    这个是通过字段的索引的。还没有测出来怎么使用。
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public BaseCodeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
       /* int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : codeOf(code);*/
       return null;
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public BaseCodeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        /*int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : codeOf(code);*/
        return null;
    }

    private E codeOf(int code){
        try {
            return CodeEnumUtil.codeOf(type, code);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + " by code value.", ex);
        }
    }
}