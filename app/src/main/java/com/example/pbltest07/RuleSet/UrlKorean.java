package com.example.pbltest07.RuleSet;

import com.example.pbltest07.RuleBase;

public class UrlKorean extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public UrlKorean(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public void rule() {
        String checkDot = url;
        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        if(Integer.parseInt(String.valueOf(c))<= 0){
            //한국어가 url에 있으면, ascii code 값이 음수
            setHypothesis(true);
        }
    }

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
