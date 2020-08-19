package dao;

import entity.Comment;
import entity.User;
import entity.Video;
import utils.Page;


import java.sql.SQLException;
import java.util.List;

public interface CommentDao {

    //添加评论
    public int insertComment(List<Object> objects  );

    //根据ID删除
    public int deleteComment(int id);

    //根据用户查询评论
    public List<Comment> queryCommentByUser(User user);
    //根据影片查询评论
    public List<Comment> queryCommentByUser(Video video);
    //修改评论
    public int updataComment(List<Object> objects );
}
