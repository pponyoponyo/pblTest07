package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class NumOfLines extends Rule {

    private String html;

    public NumOfLines(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule() {

        int brNum = 0;

        // Number of lines <br> tag
        String[] checklines = html.split("<");
        for (int j = 0; j < checklines.length; j++) {
            if (checklines[j].contains("br>")) {
                brNum++;
            }
        }

        if(brNum>10){ // br 태그가 카운팅 된 경우 return true 한다!
            return true;
        }
        return false;
    }
}
