package com.example.ietilab12.services;

import com.example.ietilab12.network.model.Token;
import com.example.ietilab12.network.model.LoginWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("login")
    Call<Token> login(@Body LoginWrapper loginWrapper);
}
