package com.huang.Shop.domain;

public class User {
    private Long tId;

    private String tUsername;

    private String tAccount;

    private String tPassword;

    private String tEmail;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername == null ? null : tUsername.trim();
    }

    public String gettAccount() {
        return tAccount;
    }

    public void settAccount(String tAccount) {
        this.tAccount = tAccount == null ? null : tAccount.trim();
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword == null ? null : tPassword.trim();
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail == null ? null : tEmail.trim();
    }
}