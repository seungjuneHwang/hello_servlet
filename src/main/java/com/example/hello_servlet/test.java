package com.example.hello_servlet;

import java.io.IOException;
import java.text.ParseException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
    public static void main(String[] args) throws ParseException {

        String URL = "https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=194196";
        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
            Elements movieList = doc.select("#targetImage");
            System.out.println(movieList.attr("src"));
//            for (Element e : movieList) {
//                System.out.println(e.attr("title"));
//                System.out.println(e.attr("href"));
//                String code = e.attr("href");
//                String [] codeArr = code.split("=");
//                System.out.println("https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=" + codeArr[1]);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}