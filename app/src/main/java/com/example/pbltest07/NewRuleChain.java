package com.example.pbltest07;

import com.example.pbltest07.RuleSet.BackSlash;
import com.example.pbltest07.RuleSet.Bitly;
import com.example.pbltest07.RuleSet.Dot;
import com.example.pbltest07.RuleSet.SuspiciousWords;
import com.example.pbltest07.RuleSet.TLDChina;

public class NewRuleChain {

    private String temp = "http://www.naver.com/";
    private int EviNum=0;

    NewRuleChain(){

        if(Bitly.rule(temp)&& SuspiciousWords.rule(temp)){
            // bitly url + html 소스코드의 내용에 의심스러운 단어가 있는경우 (예: 택배)
            EviNum++;
        }

        if(BackSlash.rule(temp)&& Dot.rule(temp)){
            // 권한 및 경로 탈취 url

            EviNum++;
        }






    }
}
