package com.pdamkotamadiun.aduin.activity.supervisor;

import android.os.Bundle;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.activity.BaseActivity;
import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;

import java.util.List;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
