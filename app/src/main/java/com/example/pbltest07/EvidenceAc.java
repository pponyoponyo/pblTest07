package com.example.pbltest07;

import android.content.Context;
import android.widget.Toast;

import com.example.pbltest07.RuleSet.BackSlash;
import com.example.pbltest07.RuleSet.Bitly;
import com.example.pbltest07.RuleSet.Dot;
import com.example.pbltest07.RuleSet.EvalMethod;
import com.example.pbltest07.RuleSet.LengthOfDoc;
import com.example.pbltest07.RuleSet.LengthOfURL;
import com.example.pbltest07.RuleSet.NumOfLines;
import com.example.pbltest07.RuleSet.SuspiciousWords;
import com.example.pbltest07.RuleSet.TLD;
import com.example.pbltest07.RuleSet.UrlKorean;
import com.example.pbltest07.RuleSet.WindowOpenMethod;

public class EvidenceAc {

    private String url = "http://www.naver.com/";
    private int total = 0;
    private int trueNum = 0;
    private float resultN = 0;
    private Context context;

    public void EvidenceAc(){
        BackSlash backSlash = new BackSlash(url);
        Bitly bitly = new Bitly(url);
        Dot dot=new Dot(url);
        EvalMethod evalMethod = new EvalMethod(url);
        LengthOfDoc lengthOfDoc = new LengthOfDoc(url);
        LengthOfURL lengthOfURL = new LengthOfURL(url);
        NumOfLines numOfLines = new NumOfLines(url);
        SuspiciousWords suspiciousWords = new SuspiciousWords(url);
        TLD tld = new TLD(url);
        WindowOpenMethod windowOpenMethod = new WindowOpenMethod(url);
        UrlKorean urlKorean = new UrlKorean(url);

        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //상위 권한 탈취 가능성
            }
        }

        if(tld.isCn_hypothesis()||tld.isRu_hypothesis()){
            // 러시아와 중국에 위치한 TLD
        }

        /*
        if(backSlash.rule()){
            trueNum++;
        }
        count();

        if(tld.rule()){
            trueNum++;
        }
        count();

        if(bitly.rule() && suspiciousWords.rule()){
            trueNum++;
        }
        count();

        if(backSlash.rule()&& dot.rule()){
            // 권한 및 경로 탈취 url
            trueNum++;
        }
        count();*/

        result();
    }

    private void count(){
        total ++;
    }

    private void result(){
        resultN = total/trueNum;
    }
}
