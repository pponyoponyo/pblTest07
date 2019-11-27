package com.example.pbltest07.RuleSet;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NumOfLines {

    static private String url;
    static private String input;
    static private int truenum;

    static public boolean rule(final String html) {

        String checkDocument = html;
        char[] d; // null 로 초기화
        d = checkDocument.toCharArray(); // htmldocument문자열을 char 배열로 설정

        input = url;

        LengthOfDoc.JsoupAsyncTask jsoupHttp = new LengthOfDoc.JsoupAsyncTask();
        jsoupHttp.execute();

        // Number of lines <br> tag
        String[] checklines = html.split("<");
        for (int j = 0; j < checklines.length; j++) {
            if (checklines[j].contains("br>")) {
                truenum++;
            }

        }

        if(truenum>0){ // br 태그가 카운팅 된 경우 return true 한다!
            return true;
        }
        return false;
    }



        static class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
            private String htmlData = "";

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Document doc = Jsoup.connect(input).get();
                    htmlData = doc.html(); // html 소스 긁어오기

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {

                if (htmlData.equals("")) {
                    return;
                } else {
                    url = htmlData;
                }
            }
        }


    }
