package com.example.hello_servlet;

import com.example.hello_servlet.utils.NaverApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MovieServlet", value = "/movie")
public class MovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> movieList = NaverApi.movie();
//        for (String m : movieList) {
//            System.out.println(m);
//        }
//        Gson gson = new Gson();
//        String jsonList = gson.toJson(movieList);
//        System.out.println(jsonList);    // 특수문자가 깨진다
//        Map<String,String> map = new HashMap<String,String>();
//        for (String img : movieList) {
//            map.put("img", img);
//        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(movieList);
        System.out.println(json);
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
