package com.ssm.mapper;

import com.ssm.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * 通过ID查询单本图书
     *
     * @param id
     * @return
     */
    Book queryById(long id);
    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     * 知识点：@Param注解。相当于给#{offset}, #{limit}里面的值进行匹配。
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);
}
