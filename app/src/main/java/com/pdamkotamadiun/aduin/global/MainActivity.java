package com.pdamkotamadiun.aduin.global;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.supervisor.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_login_edittext_username)
    EditText etUsername;

    @BindView(R.id.activity_login_edittext_password)
    EditText etPassword;

    @BindView(R.id.activity_login_button_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btLogin.setOnClickListener(v -> onLogin());
    }

    public void onLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        onLoginSuccess();
    }

    public void onLoginSuccess() {
        Intent intentToHomeActivityFromMainActivity = new Intent(this, HomeActivity.class);
        startActivity(intentToHomeActivityFromMainActivity);
    }
}
