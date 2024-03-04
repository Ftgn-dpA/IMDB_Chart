package qst.controller;

import com.alibaba.fastjson.JSON;
import qst.bean.MovieBean;
import qst.dao.MovieDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/imdb")
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        MovieDao movieDao = new MovieDao();
        String sql = "select * from output";
        List<MovieBean> list = movieDao.getAllMovie(sql);
        System.out.println("list = " + list);

        String json = JSON.toJSONString(list);
        System.out.println("json = " + json);

        PrintWriter out = response.getWriter();
        out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
