package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class UrlKorean extends Rule {

    private String url;

    public UrlKorean(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public boolean rule() {
        String checkDot = url;
        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        if(Integer.parseInt(String.valueOf(c))<= 0){
            //한국어가 url에 있으면, ascii code 값이 음수
            return true;
        }
        return false;
    }
}
