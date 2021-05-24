package com.example.ietilab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ietilab12.network.RetrofitNetwork;
import com.example.ietilab12.network.model.LoginWrapper;
import com.example.ietilab12.network.model.Token;
import com.example.ietilab12.services.AuthService;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    private EditText editTextEmail;
    private EditText editTextPassword;
    private SharedPreferences sharedPreferences;
    private AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        loadComponents();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if (email.isEmpty()) editTextEmail.setError("This field can not be blank");
        if (password.isEmpty()) editTextPassword.setError("This field can not be blank");
        if (!email.isEmpty() && !password.isEmpty()) {
            executorService.execute(() -> {
                try {
                    Response<Token> response =
                            authService.login(new LoginWrapper(email, password)).execute();
                    Token token = response.body();
                    runOnUiThread(() -> {
                        if (response.isSuccessful()) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(LaunchActivity.TOKEN_KEY, token.getAccessToken());
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            editTextEmail.setText("");
                            editTextPassword.setText("");
                        } else {
                            editTextPassword.setError("Invalid Credentials");
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void loadComponents() {
        editTextEmail = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        //localhost for emulator
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/user/") //localhost for emulator
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authService = retrofit.create(AuthService.class);
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }
}
