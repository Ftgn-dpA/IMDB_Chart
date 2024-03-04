package qst.dao;

import qst.bean.MovieBean;
import qst.util.SqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    /**
     * 查询所有信息
     *
     * @param sql
     * @return
     */
    public List<MovieBean> getAllMovie(String sql) {
        List<MovieBean> lists = new ArrayList<MovieBean>();
        ResultSet resultSet = SqlUtils.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String month = resultSet.getString("month");
                String genres = resultSet.getString("genres");
                float popularity = resultSet.getFloat("popularity");
                lists.add(new MovieBean(month, genres, popularity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    //分页查询
    public List<MovieBean> getPageMovie(String sql, int start, int end) {
        List<MovieBean> lists = new ArrayList<MovieBean>();
        ResultSet resultSet = SqlUtils.executeQuery(sql, start, end);
        try {
            while (resultSet.next()) {
                String month = resultSet.getString("month");
                String genres = resultSet.getString("genres");
                float popularity = resultSet.getFloat("popularity");
                lists.add(new MovieBean(month, genres, popularity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

}
