package com.ssm.service.impl;

import com.ssm.bean.Appointment;
import com.ssm.bean.Book;
import com.ssm.dto.AppointExecution;
import com.ssm.enums.AppointStateEnum;
import com.ssm.exception.AppointException;
import com.ssm.exception.NoNumberException;
import com.ssm.exception.RepeatAppointException;
import com.ssm.mapper.AppointmentMapper;
import com.ssm.mapper.BookMapper;
import com.ssm.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    public Book getById(long bookId) {
        return bookMapper.queryById(bookId);
    }

    public List<Book> getList() {
        return bookMapper.queryAll(0, 1000);
    }

    public AppointExecution appoint(long bookId, long studentId) {
        try{
            //减少库存，用来判断数据库中有没有库存。
            int update=bookMapper.reduceNumber(bookId);
            //没有库存
            if(update <=0){
                throw new NoNumberException("no number");
            }else {
                //执行预约
                int insert = appointmentMapper.insertAppointment(bookId, studentId);
                //重复预约。数据库保存的时候没有返回数
                if(insert <= 0){
                    throw new RepeatAppointException("repeat appoint");
                }else {
                    //预约成功
                    Appointment appointment = appointmentMapper.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
