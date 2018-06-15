package kr.ac.ks.twitterclone.controller;

import javax.validation.constraints.Size;

public class TweetForm {
    @Size(min = 1,max = 255,message = "255자를 넘길 수 없어요!")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
