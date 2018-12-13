package com.pdamkotamadiun.aduin.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.activity.LoginActivity;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    String mToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToken = getApplicationContext()
                .getSharedPreferences("token", 0)
                .getString("token", null);
    }

    @Override
    protected void onDestroy() {
        removeSharedPereferences();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.menu_account:
                onAccount();
                return true;
            case R.id.menu_logout:
                onLogout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }

    private void onAccount() {
        Log.d(TAG, "onAccount: " + "wew");
        Intent intentToAccount = new Intent(this, AccountActivity.class);
        startActivity(intentToAccount);
    }

    private void onLogout() {
        Intent intentToLogin = new Intent(this, LoginActivity.class);
        startActivity(intentToLogin);
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    private void removeSharedPereferences() {
        getApplicationContext()
                .getSharedPreferences("token", 0)
                .edit()
                .remove("token")
                .apply();
    }
}
