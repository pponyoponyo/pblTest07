package com.example.pbltest07.RuleSet;

import com.example.pbltest07.RuleBase;

public class TLD extends RuleBase {

    private String url;
    private boolean cn_hypothesis = false;
    private boolean ru_hypothesis = false;

    public TLD(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public void rule() {

        if(url.contains(".cn")){
            setCn_hypothesis(true);
        }

        if(url.contains(".ru")){
            setRu_hypothesis(true);
        }
    }

    public boolean isCn_hypothesis() {
        return cn_hypothesis;
    }

    public void setCn_hypothesis(boolean cn_hypothesis) {
        this.cn_hypothesis = cn_hypothesis;
    }

    public boolean isRu_hypothesis() {
        return ru_hypothesis;
    }

    public void setRu_hypothesis(boolean ru_hypothesis) {
        this.ru_hypothesis = ru_hypothesis;
    }
}
