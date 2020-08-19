package dao.Impl;

import dao.BaseDao;
import dao.CommentDao;
import entity.Comment;
import entity.User;
import entity.Video;
import utils.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {

public BaseDao baseDao=new BaseDao();
    @Override
    public int insertComment(List<Object> objects ) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO comment ");
        sb.append(" (commentUserId,commentVideoId,commentDataTime,commentContent)");
        sb.append(" VALUES (?,?,?,?)");
        int count = baseDao.executeUpdate(sb.toString(),objects.toArray());
        return count;
    }

    @Override
    public int deleteComment(int id) {
        return 0;
    }

    @Override
    public List<Comment> queryCommentByUser(User user) {
        String sql = "SELECT * FROM comment where commentUserId =?";
       List<Object> objects=new ArrayList<>();
       objects.add(user.getUserId());
        ResultSet set = baseDao.executeQuery(sql, objects.toArray());
        List<Comment> list = new ArrayList<>();
        try {
            while(set.next()){
                Comment comment = tableToClass(set);
                list.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Comment> queryCommentByUser(Video video) {
        String sql = "SELECT * FROM comment where commentVideoId =?";
        List<Object> objects=new ArrayList<>();
        objects.add(video.getVideoId());
        ResultSet set = baseDao.executeQuery(sql, objects.toArray());
        List<Comment> list = new ArrayList<>();
        try {
            while(set.next()){
                Comment comment = tableToClass(set);
                list.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public int updataComment(List<Object> objects) {
        return 0;
    }
    public Comment tableToClass(ResultSet rs) throws Exception {
        Comment comment = new Comment();
       comment.setCommentUserId(rs.getInt("commentUserId"));
       comment.setCommentVideoId(rs.getInt("commentVideoId"));
       comment.setCommentDataTime(rs.getString("commentDataTime"));
       comment.setCommentContent(rs.getString("commentContent"));
       comment.setCommentId(rs.getInt("commentId"));
        return comment;
    }
}
