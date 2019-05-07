package com.example.admin.login;

import android.content.Context;

import com.example.admin.login.Koneksi.BaseApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterRegister {
    private Context context;
    private RegisterView registerView;

    public PresenterRegister(Context context, RegisterView registerView) {
        this.context = context;
        this.registerView = registerView;
    }

    public void create(String name, String email, String password){
        BaseApp.service.PostCreate(email,password,name).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    registerView.onSucces(response.message());
                } else {
                    registerView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                registerView.onFailure(t.getMessage());
            }
        });

    }
}
