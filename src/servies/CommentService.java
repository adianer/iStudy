package servies;


import com.bdqn.financing.utils.DataSourceUtil;
import dao.BaseDao;
import dao.CommentDao;
import dao.Impl.CommentDaoImpl;
import entity.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author draw_heart
 * @date 2020.08.18
 * 评论业务类
 */
public class CommentService  {

	/**
	 * 新增评论信息
	 *
	 * @param objects 参数数组
	 * @return 是否成功
	 */
	public boolean insertComment(List<Object> objects) {
		Connection connection = null;
		int count = 0;
		boolean flag = false;
		try {
			connection = BaseDao.getConnection();
			CommentDao CommentDao = new CommentDaoImpl();
			count = CommentDao.insertComment(objects);
			if(count > 0){
				flag = true;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Comment> getpartComment(HttpServletRequest request,List<Object> objects) {
		Connection connection = null;
		List<Comment> list = new ArrayList<>();

		try {
			connection = BaseDao.getConnection();
			CommentDao CommentDao = new CommentDaoImpl();
			list = CommentDao.selectPartComment(objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
