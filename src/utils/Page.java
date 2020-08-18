package utils;

import dao.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 2019/12/9.
 */
public class Page<T> {
    private Integer pageNo=0;//当前页的页码
    private Integer pageSize=5;//每页显示的记录数
    private  Integer Count;//总记录数
    private Integer pageCount;//总页数
    private List<T> date;//存储查询到的分页片段记录

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getCount() {
        return Count;
    }
    public void setCount(int count)
    {
        this.Count = count;
        getPageCount();
    }
    public Integer getPageCount() {
        if(this.Count % this.pageSize==0){
            this.pageCount=Count/pageSize;
        }else {
            this.pageCount=Count/pageSize+1;
        }
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    //获取当前页查询的片段数据中，第一条记录的下标
    public Integer getFirstRecord(){
        return  (pageNo-1)*pageSize;
    }

}
