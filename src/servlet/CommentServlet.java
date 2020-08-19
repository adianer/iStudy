package servlet;


import entity.Comment;
import entity.Message;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/Comment"},name = "comment")
public class CommentServlet extends com.bdqn.financing.servlet.AbstractServlet {
    /**
     * 获取servlet类对象
     *
     * @return
     */
    @Override
    public Class getServletClass() {
        return CommentServlet.class;
    }
    public CommentService CommentService = null;
    @Override
    public void init() throws ServletException {
        super.init();
        CommentService = new CommentService();
    }


    /**
     * 条件查询控制器
     * @param
     * @param response
     */
    public String getpartComment(HttpServletRequest request, HttpServletResponse response){
        List<Comment> partComment = CommentService.getpartComment(request);
        request.setAttribute("commentList",partComment);
        return  "Comment";
    }
    /**
     * 新增评论控制器
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    public Message insertComment(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 实体类映射
        List<Object> objects=new ArrayList<>();
        User user=(User)request.getAttribute("user");
        objects.add(user.getUserId());
        objects.add(Integer.parseInt(request.getParameter("videoId")));
        objects.add(request.getParameter("commentContent"));
        //获取评论时间
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dt.format(new Date());
        objects.add(date);
        boolean b = CommentService.insertComment(objects);
        Message message = new Message();
        if(b){
            message.setCode(1);
            message.setMessage("插入成功");
        } else{
            message.setCode(0);
            message.setMessage("插入失败");
        }
        return message;
    }
}
