package com.example.pbltest07;

import com.example.pbltest07.RuleSet.BackSlash;
import com.example.pbltest07.RuleSet.Bitly;
import com.example.pbltest07.RuleSet.Dot;
import com.example.pbltest07.RuleSet.SuspiciousWords;
import com.example.pbltest07.RuleSet.TLD;

public class EvidenceAc {

    private String url = "http://www.naver.com/";
    private int total = 0;
    private int trueNum = 0;
    private float resultN = 0;

    EvidenceAc(){
        BackSlash backSlash = new BackSlash(url);
        Bitly bitly = new Bitly(url);
        SuspiciousWords suspiciousWords = new SuspiciousWords(url);
        TLD tld = new TLD(url);

        if(backSlash.rule()){
            trueNum++;
        }
        count();

        if(tld.rule()){
            trueNum++;
        }
        count();

        if(bitly.rule() && suspiciousWords.rule()){
            //TODO 다른 작업?
        }

        result();
    }

    private void count(){
        total ++;
    }

    private void result(){
        resultN = total/trueNum;
    }

}
