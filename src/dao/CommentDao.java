package dao;

import entity.Comment;
import entity.Video;
import utils.Page;


import java.sql.SQLException;
import java.util.List;

public interface CommentDao {
    //获取显示列表
    public List getshowlist(Page page) throws Exception;


    //获取总记录数
    public int getCount();

    //添加评论
    public int insertComment(List<Object> objects );

    //根据ID删除
    public int deleteComment(int id);

    //根据id查询
    public Video queryCommentById(int id);

    //修改评论
    public int updataComment(List<Object> objects );
}
