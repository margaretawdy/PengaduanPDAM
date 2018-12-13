package com.pdamkotamadiun.aduin.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.activity.supervisor.HomeActivity;
import com.pdamkotamadiun.aduin.model.token.TokenResponse;
import com.pdamkotamadiun.aduin.service.LoginService;
import com.pdamkotamadiun.aduin.utils.ServiceGeneratorUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    public static final int REQUEST_LOGIN = 0;

    ProgressDialog mProgressDialog;
    LoginService mLoginService;

    @BindView(R.id.activity_login_linearLayout)
    LinearLayout linearLayout;

    @BindView(R.id.activity_login_editText_username)
    EditText etUsername;

    @BindView(R.id.activity_login_editText_password)
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

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_LOGIN) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    public void onLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        initProgressDialog();

        mLoginService = ServiceGeneratorUtils.createService(LoginService.class);
        Call<TokenResponse> call = mLoginService.getToken(username, password);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(@NonNull Call<TokenResponse> call, @NonNull Response<TokenResponse> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.body() != null) {
                    if (response.body().isError()) {
                        onLoginFailed();
                    } else {
                        String token = response.body().getToken().getToken();

                        getApplicationContext()
                                .getSharedPreferences("token", 0)
                                .edit()
                                .putString("token", token)
                                .apply();

                        onLoginSuccess();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TokenResponse> call, @NonNull Throwable t) {
                onLoginFailed();
            }
        });
    }

    public void initProgressDialog() {
        mProgressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Sabar ya, login nih...");
        mProgressDialog.show();
    }

    public void onLoginSuccess() {
        mProgressDialog.dismiss();
        Intent intentToHomeActivityFromMainActivity = new Intent(this, HomeActivity.class);
        startActivity(intentToHomeActivityFromMainActivity);
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public void onLoginFailed() {
        mProgressDialog.dismiss();

        Snackbar snackbar = Snackbar.make(linearLayout, "Sayang nih, login gagal...", Snackbar.LENGTH_LONG);
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }
}
