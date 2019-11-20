package com.example.pbltest07;

import com.example.pbltest07.RuleSet.BackSlash;
import com.example.pbltest07.RuleSet.Bitly;
import com.example.pbltest07.RuleSet.Dot;

public class EvidenceAc {

    private String temp = "http://www.naver.com/";
    private int total = 0;
    private int trueNum = 0;
    private float resultN = 0;

    EvidenceAc(){

        if(BackSlash.rule(temp)){
            trueNum++;
        }
        count();

        if(Dot.rule(temp)){
            trueNum++;
        }
        count();

        if(Bitly.rule(temp)){
            trueNum++;
        }
        count();

        result();
    }

    private void count(){
        total ++;
    }

    private void result(){
        resultN = total/trueNum;
    }

}
