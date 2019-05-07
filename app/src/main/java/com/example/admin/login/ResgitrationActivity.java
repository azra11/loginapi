package com.example.admin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResgitrationActivity extends AppCompatActivity implements RegisterView {
    private EditText username,userpassword,useremail;
    private Button Regist;
    private TextView userLogin;
    String email,name,password;
    PresenterRegister presenterRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgitration);

        username = (EditText)findViewById(R.id.et_uname);
        userpassword=(EditText)findViewById(R.id.et_upass);
        useremail=(EditText)findViewById(R.id.et_email);
        Regist=(Button)findViewById(R.id.b_regis);
        userLogin=(TextView)findViewById(R.id.tv_ulogin);

        presenterRegister = new PresenterRegister(getApplicationContext(), (RegisterView) this);
        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterRegister.create(username.getText().toString(),useremail.getText().toString(), userpassword.getText().toString());
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResgitrationActivity.this,LoginActivity.class));
            }
        });


    }

    @Override
    public void onSucces(String regis) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

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
