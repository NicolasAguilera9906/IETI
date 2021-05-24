package com.example.ietilab12.services;

import com.example.ietilab12.model.Token;
import com.example.ietilab12.model.LoginWrapper;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("login")
    Call<Token> login(@Body LoginWrapper loginWrapper);
}
