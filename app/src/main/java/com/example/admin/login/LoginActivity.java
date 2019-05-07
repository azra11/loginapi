package com.example.admin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.login.Koneksi.sharedpreferencesconfig;
import com.example.admin.login.model.PostLoginResponse;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText username1,password1;
    private Button login1;
    private TextView Registerr;
    private LoginPresenter loginPresenter;
    private sharedpreferencesconfig preferenceconfig;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferenceconfig = new sharedpreferencesconfig(getApplicationContext());
        username1 = findViewById(R.id.et_user);
        password1 = findViewById(R.id.et_pass);
        login1 = findViewById(R.id.b_login);

        if (preferenceconfig.readLoginStatus()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        Registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ResgitrationActivity.class));
            }
        });
    }
    public void loginUser() {
        String username = username1.getText().toString();
        String userpassword = password1.getText().toString();
        loginPresenter = new LoginPresenter(getApplicationContext(),this);
        loginPresenter.login(username,userpassword);
    }

    @Override
    public void onSucces(PostLoginResponse login) {
        preferenceconfig.token(login.getToken());
        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getApplicationContext(),errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getApplicationContext(),failureMessage,Toast.LENGTH_SHORT).show();

    }
}
