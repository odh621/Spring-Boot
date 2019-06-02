package kr.ac.ks.twitterclone.controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {
    @Size(min = 4,max = 20,message = "20자 미만으로 입력해주세요")
    @Pattern(regexp = "[a-zA-Z0-9]*",message = "영어 또 숫자만 사용해주세요")
    private String userId;

    @Size(min = 4,max = 20,message = "20자 미만으로 입력해주세요")
    @Pattern(regexp = "[a-zA-Z0-9]*",message = "영어 또 숫자만 사용해주세요")
    private String password;

    @Size(max = 25,message = "닉네임은 25 자 이하입니다")
    private String screenName;


    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
