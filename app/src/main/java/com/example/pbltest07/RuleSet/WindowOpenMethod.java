package com.example.pbltest07.RuleSet;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WindowOpenMethod {

    static private String url;
    static private String input;

    static public boolean rule(final String html){

        input = url;

        JsoupAsyncTask jsoupHttp = new JsoupAsyncTask();
        jsoupHttp.execute();

        if(html.contains("window.open()")){
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

            if(htmlData.equals("")){
                return;
            }else{
                url = htmlData;
            }
        }
    }


}




