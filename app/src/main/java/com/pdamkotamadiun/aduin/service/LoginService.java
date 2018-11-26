package com.pdamkotamadiun.aduin.service;

import com.pdamkotamadiun.aduin.model.token.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("token")
    Call<Token> getToken(@Field("username") String username, @Field("password") String password);
}
