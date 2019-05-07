package com.example.admin.login.Koneksi;

import com.example.admin.login.model.CreateResponse;
import com.example.admin.login.model.LoginResponse;
import com.example.admin.login.model.PostLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiLogin {
    @FormUrlEncoded
    @POST("/users/login") //dapet dari postman, hrs punya postman
    Call<PostLoginResponse> PostUserResponse (@Field("email") String email,
                                              @Field("password") String passw);

    @FormUrlEncoded
    @POST("/users")
    Call<Void> PostCreate (@Field("email") String email,
                           @Field("password") String passw,
                           @Field("name") String name);

    @GET("/users/")
    Call<LoginResponse> getUser (@Header("x-access-token")String token);

    @PUT("/users/")
    Call<CreateResponse> updateUser (@Header("x-access-token") String token,
                                     @Field("name") String name);
}
