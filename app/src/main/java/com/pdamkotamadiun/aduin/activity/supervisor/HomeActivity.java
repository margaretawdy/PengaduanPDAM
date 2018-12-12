package com.pdamkotamadiun.aduin.activity.supervisor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.activity.BaseActivity;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "HomeActivity";

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSharedPreferences = getApplicationContext().getSharedPreferences("token", 0);
        String token = mSharedPreferences.getString("token", null);
        Log.d(TAG, "onCreate: " + token);
    }
}
