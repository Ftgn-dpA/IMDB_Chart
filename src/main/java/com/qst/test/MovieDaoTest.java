package qst.test;

import com.alibaba.fastjson.JSON;
import qst.bean.MovieBean;
import qst.dao.MovieDao;

import java.util.List;

public class MovieDaoTest {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
        String sql = "select * from output limit ?,?";
        List<MovieBean> pageMovie = movieDao.getPageMovie(sql, 0, 3);
//        System.out.println(pageGps);
        String json = JSON.toJSONString(pageMovie);
        System.out.println(json);

    }
}
