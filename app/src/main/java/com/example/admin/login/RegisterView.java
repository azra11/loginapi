package com.example.admin.login;

public interface RegisterView {
    void onSucces(String regis);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
