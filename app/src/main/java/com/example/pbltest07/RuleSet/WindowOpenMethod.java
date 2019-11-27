package com.example.pbltest07.RuleSet;

import android.os.AsyncTask;

import com.example.pbltest07.Rule;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WindowOpenMethod extends Rule {

    private String html;

    public WindowOpenMethod(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        if(html.contains("window.open()")){
            return true;
        }
        return false;
    }
}




