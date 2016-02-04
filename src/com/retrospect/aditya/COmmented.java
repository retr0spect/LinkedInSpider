package com.retrospect.aditya;

/**
 * Created by Aditya on 2/4/2016.
 */
public class Commented {

    /*String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
        Connection.Response response = Jsoup
                .connect(url)
                .method(Connection.Method.GET)
                .execute();

        Document responseDocument = response.parse();
        Element loginCsrfParam = responseDocument
                .select("input[name=loginCsrfParam]")
                .first();

        response = Jsoup.connect("https://www.linkedin.com/uas/login-submit")
                .cookies(response.cookies())
                .data("loginCsrfParam", loginCsrfParam.attr("value"))
                .data("session_key", "hekulitibo@thrma.com")
                .data("session_password", "Asdfvcxz")
                .method(Connection.Method.POST)
                .followRedirects(true)
                .execute();

        Document document = response.parse();

        //            System.out.println(document)

        System.out.println("Welcome " + document.select(".act-set-name-split-link").html());


        response = Jsoup.connect("https://www.linkedin.com/vsearch/p?f_CC=861427")
                .cookies(response.cookies())
                .method(Connection.Method.POST)
                .execute();

        document = response.parse();

        System.out.println(document);*/
}
