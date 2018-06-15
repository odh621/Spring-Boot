package kr.ac.ks.twitterclone.controller;

import javax.validation.constraints.Size;

public class UserForm {
    @Size(max = 25,message = "255자를 넘길 수 없어요!")
    private String screenName;

    private String biography;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
