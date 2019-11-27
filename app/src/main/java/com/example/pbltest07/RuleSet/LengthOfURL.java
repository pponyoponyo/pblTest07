package com.example.pbltest07.RuleSet;

public class LengthOfURL {

    static public Boolean rule(String url){

        String checkDot = url;
        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        //Length of URL
        if(c.length>40){
          return true;
    }
        return false;
    }
}
