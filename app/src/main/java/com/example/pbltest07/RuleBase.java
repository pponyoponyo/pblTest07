package com.example.pbltest07;


import android.content.Context;

import com.example.pbltest07.RuleSet.BackSlash;

public class RuleBase {

    private String temp = "1dsdfdsfd/dsfds";
    private int total = 0;
    private int trueNum = 0;

    RuleBase(){
        if(BackSlash.rule(temp)){
            trueNum++;
        }
        count();
        
    }

    private void count(){
        total ++;
    }

}
