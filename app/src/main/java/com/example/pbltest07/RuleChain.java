package com.example.pbltest07;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.pbltest07.Activity.ResultActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RuleChain {

    private String inputUrl ="";
    private String reason = "";
    public int percent = 0; // collect 변수 역할
    private Context context;

    RuleChain(Context context){
        this.context = context;
    }

    public void totalCheck(String urlData){

        checkInput(urlData);


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



    private void ruleUrl(String urlSource){

        String checkDot = urlSource;

        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        //Length of URL
        if(c.length>40){
            percent += 1;
            reason += "RuleBase Url > Length of URL\n";
        }

        for(int i=0; i<c.length; i++){

        //Suspicious Strings (“@”,”//”,”?”,”=”,”-“,”_”) , \

            if(c[i]=='@'){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }

            if(c[i]=='?'){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }

            if(c[i]=='='){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }

            if(c[i]=='-'){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }

            if(c[i]=='_'){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }


            if(c[i]=='/'&&c[i+1]=='/'){
                percent += 1;
                reason += "RuleBase Url > Suspicious Strings\n";
            }

            // .. 상위 권한으로 넘어갈 가능성 ( . 개수)
            if(c[i]=='.'&&c[i+1]=='.'){
                percent += 1;
                reason += "RuleBase Url > 상위 권한으로 넘어갈 가능성이 있다.\n";
            }

            // Number of "\"
            if(c[i]=='\\'){
                percent += 1;
                reason += "RuleBase Url > Detection of \\ \n";
            }

        }

            // Number of TLD and out of TLD position (China)
            if(urlSource.contains(".cn")){
                percent +=10;
                reason+="RuleBase Url > Url from China\n";
            }

            // Number of TLD and out of TLD position (Russia)
            if(urlSource.contains(".ru")){
                percent +=10;
                reason+="RuleBase Url > Url from Russia\n";
            }


        if(reason == ""){
            reason = "정상적인 url 입니다.\n";
        }
    }

    private void ruleHtml(String htmlSource){

        String checkDocument = htmlSource;
        char [] d ; // null 로 초기화
        d = checkDocument.toCharArray(); // htmldocument문자열을 char 배열로 설정

        int iframeNum=0,hiddenNum=0, popupNum = 0, aNum=0, lineNum=0, wordNum=0;

        // Document length
        if(d.length>100){ // 100은 임의 값
            percent += 1;
            reason += "RuleBase Url > Length of Document\n";
        }

        // Number of lines <br> tag
        String [] checklines=htmlSource.split("<");

        for (int j=0; j<checklines.length;j++){
            if(checklines[j].contains("br>")){
                lineNum++;
            }


            //Number of words
            String [] checkwords=checklines[j].split(" ");
            for(int k=0; k<checkwords.length; k++){
                wordNum++;
            }

        }


        // exploit() 존재
        if(htmlSource.contains("exploit.DownloadFromUrl(")){
            percent += 1;
            reason += "RuleBase Html > DownloadFromUrl 메소드가 탐지되었습니다.\n";
        }

       // *다시 코드 수정해야 할 듯 *
        String [] checkBig = htmlSource.split("<");
        for(int i=0;i<checkBig.length;i++){

            if(checkBig[i].contains("script")){
                String [] checkScript = checkBig[i].split(";");

                for(int j=0;j<checkScript.length;j++){
                    // window.open() 존재
                    if( checkScript[j].contains("window.open")){
                        popupNum++;
                        percent +=1;
                    }
                    // eval() 존재
                    if( checkScript[j].contains("eval")){
                        percent +=1;
                        reason+="RuleBase Html > eval() 메소드가 탐지되었습니다.\n";
                    }

                    // escape() 존재
                    if( checkScript[j].contains("escape")){
                        percent +=1;
                        reason+="RuleBase Html > escape() 메소드가 탐지되었습니다.\n";
                    }

                    // charCodeAt() 존재
                    if( checkScript[j].contains("charCodeAt")){
                        percent +=1;
                        reason+="RuleBase Html > charCodeAt() 메소드가 탐지되었습니다.\n";
                    }

                    // fromCharCode() 존재
                    if( checkScript[j].contains("fromCharCode")){
                        percent +=1;
                        reason+="RuleBase Html > fromCharCode() 메소드가 탐지되었습니다.\n";
                    }

                    // parseInt() 존재
                    if( checkScript[j].contains("parseInt")){
                        percent +=1;
                        reason+="RuleBase Html > parseInt() 메소드가 탐지되었습니다.\n";
                    }

                }
                continue;
            }

            String [] checkMid =  checkBig[i].split(">");
            for(int j=0;j<checkMid.length;j++){
                String [] checkSmall =  checkMid[j].split(" ");
                for(int k=0;k<checkSmall.length;k++){

                    // Number of Hidden tag
                    if(checkSmall[k].equals("hidden")){
                        hiddenNum ++;
                    }
                    //Number of iframes
                    if(checkSmall[k].equals("iframe")){
                        iframeNum ++;
                    }

                    // Number of <a> tag
                    if(checkSmall[k].equals("a")){
                        aNum ++;
                    }
                }
            }
        }

        if(iframeNum >=1){
            percent += 1;
            reason += "RuleBase Html > iframe 개수가 " + iframeNum + "개 탐지되었습니다.\n";
        }

        if(hiddenNum >=1){
            percent += 1;
            reason += "RuleBase Html > hidden tag의 개수가 " + hiddenNum + "개 탐지되었습니다.\n";
        }

        if(popupNum >=1){
            percent += 1;
            reason += "RuleBase Html > popup 함수의 개수가 " + popupNum + "개 탐지되었습니다.\n";
        }

        if(aNum >=1){
            percent += 1;
            reason += "RuleBase Html > <a> tag의 개수가 " + aNum + "개 탐지되었습니다.\n";
        }

        if(lineNum>=1){
            percent += 1;
            reason += "RuleBase Html > Document line 개수가 " + lineNum + "개 탐지되었습니다.\n";
        }


        if(wordNum>=1){
            percent += 1;
            reason += "RuleBase Html > word 개수가 한 줄에  " + wordNum + "개 탐지되었습니다.\n";
        }


    }

     // 룰체인1 예시
     private void ruleChain1 (String urlSource, String htmlSource){
        if(urlSource.contains("bit.ly")){
            percent +=0;
            if(htmlSource.contains("택배")){
                percent +=10;
            }
        }

     }





    }



