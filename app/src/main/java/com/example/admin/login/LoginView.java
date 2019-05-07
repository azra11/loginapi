package com.example.admin.login;


import com.example.admin.login.model.PostLoginResponse;

public interface LoginView {
    void onError(String errorMessage);
    void onFailure(String failureMessage);
    void onSucces(PostLoginResponse body);
}
