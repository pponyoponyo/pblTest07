package com.example.pbltest07;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RuleB{

    private String inputUrl ="";
    private  String reason = "";
    private int percent = 0;
    private Context context;

    RuleB(Context context){
        this.context = context;
    }

    public void totalCheck(String urlData){

        checkInput(urlData);

        JsoupAsyncTask jsoupHttp = new JsoupAsyncTask();
        jsoupHttp.execute();

    }

    private void checkInput(String urlData) {

        //만약 문자가 공유 되었을 때 방안
        if(urlData.contains(" ")){
            String temp1[]
                    = urlData.split("http");
            String temp2[] = temp1[1].split("\n");
            urlData = "http" + temp2[0];
        }

        //domain name 만 입력 되었을 때
        if(!urlData.contains("http")){
            if(!urlData.contains("www")){
                inputUrl = "https://www." + urlData;
            }else{
                inputUrl = "https://" + urlData;
            }
        }else{
            inputUrl = urlData;
        }
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        private String htmlData = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Document doc = Jsoup.connect(inputUrl).get();
                htmlData = doc.html(); // html 소스 긁어오기

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if(htmlData.equals("")){
                reason = "오류 :"+inputUrl;
            }else{
                ruleUrl(inputUrl);
                ruleHtml(htmlData);
            }

            Bundle data = new Bundle();
            data.putString("reason",reason);
            data.putInt("percent",percent);

            Intent intent = new Intent(context,ResultActivity.class);
            intent.putExtras(data);
            context.startActivity(intent);
        }
    }

    private void ruleUrl(String urlSource){
        String checkDot = urlSource;

        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        //Length of URL
        if(c.length>40){
            percent += 1;
            reason += "Rule Url > Length of URL\n";
        }

        for(int i=0; i<c.length; i++){

        //Suspicious Strings (“@”,”//”,”?”,”=”,”-“,”_”)

            if(c[i]=='@'){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            if(c[i]=='?'){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            if(c[i]=='='){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            if(c[i]=='-'){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            if(c[i]=='_'){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            if(c[i]=='/'&&c[i+1]=='/'){
                percent += 1;
                reason += "Rule Url > Suspicious Strings\n";
            }

            // .. 상위 권한으로 넘어갈 가능성이 있다.
            if(c[i]=='.'&&c[i+1]=='.'){
                percent += 1;
                reason += "Rule Url > 상위 권한으로 넘어갈 가능성이 있다.\n";
            }
        }

        if(reason == ""){
            reason = "정상적인 url 입니다.\n";
        }
    }

    private void ruleHtml(String htmlSource){

        int iframeNum=0,hiddenNum=0, popupNum = 0;

        if(htmlSource.contains("exploit.DownloadFromUrl(")){
            percent += 1;
            reason += "Rule Html > DownloadFromUrl 메소드가 탐지되었습니다.\n";
        }

        String [] checkBig = htmlSource.split("<");
        for(int i=0;i<checkBig.length;i++){

            if(checkBig[i].contains("script")){
                String [] checkScript = checkBig[i].split(";");
                for(int j=0;j<checkScript.length;j++){
                    if( checkScript[j].contains("window.open")){
                        popupNum++;
                    }
                }
                continue;
            }

            String [] checkMid =  checkBig[i].split(">");
            for(int j=0;j<checkMid.length;j++){
                String [] checkSmall =  checkMid[j].split(" ");
                for(int k=0;k<checkSmall.length;k++){

                    if(checkSmall[k].equals("hidden")){
                        hiddenNum ++;
                    }
                    if(checkSmall[k].equals("iframe")){
                        iframeNum ++;
                    }
                }
            }
        }

        if(iframeNum >=1){
            percent += 10;
            reason += "Rule Html > iframe 개수가 " + iframeNum + "개 탐지되었습니다.\n";
        }

        if(hiddenNum >=1){
            percent += 10;
            reason += "Rule Html > hidden tag의 개수가 " + hiddenNum + "개 탐지되었습니다.\n";
        }

        if(popupNum >=1){
            percent += 10;
            reason += "Rule Html > popup 함수의 개수가 " + popupNum + "개 탐지되었습니다.\n";
        }
    }

}
