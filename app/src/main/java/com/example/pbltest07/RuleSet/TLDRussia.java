package com.example.pbltest07.RuleSet;

public class TLDRussia extends RuleTLD{

    public void findTLD(){
        //오버라이딩
        if(url.contains(".ru")){
            result+="Rule Url > Url from Russia";
        }

    }
}
