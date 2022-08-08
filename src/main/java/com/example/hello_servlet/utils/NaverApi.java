package com.example.hello_servlet.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NaverApi {
    public static List<String> movie()  {
        List<String> list = new ArrayList<>();
        String URL = "https://movie.naver.com/movie/sdb/rank/rmovie.naver";
        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
            Elements movieList = doc.select(".tit3 > a");
            int i = 0;
            for (Element e : movieList) {
//                System.out.println(e.attr("title"));
//                System.out.println(e.attr("href"));
                String code = e.attr("href");
                String [] codeArr = code.split("=");
//                System.out.println("https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=" + codeArr[1]);
                URL = "https://movie.naver.com/movie/bi/mi/photoViewPopup.naver?movieCode=" + codeArr[1];
                doc = Jsoup.connect(URL).get();
                Elements img = doc.select("#targetImage");

                if (i >= 9) break;
                list.add(img.attr("src"));
                i++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}
