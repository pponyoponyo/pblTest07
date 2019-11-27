package com.example.pbltest07.RuleSet;

import android.os.AsyncTask;

import com.example.pbltest07.Rule;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class EvalMethod extends Rule {

    private String html;

    public EvalMethod(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        if(html.contains("eval()")){
            return true;
        }
        return false;
    }

}
