package com.example.pbltest07.RuleSet;

public class TLDChina extends TLD {

    public void findTLD(){
        //오버라이딩
        if(url.contains(".cn")){
            result+="Rule Url > Url from China";
        }

    }
}
