package com.example.pbltest07;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Rule {

    private String url;
    private String html ="";

    public Rule(String url){
        this.url = url;
    }

    public boolean rule(){
        return false;
    }

    public String getHtml(){

        JsoupAsyncTask jsoupHttp = new JsoupAsyncTask();
        jsoupHttp.execute();

        return html;
    }


    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Document doc = Jsoup.connect(url).get();
                html = doc.html(); // html 소스 긁어오기

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

        }
    }

}
