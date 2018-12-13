package com.pdamkotamadiun.aduin.activity.supervisor;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.activity.BaseActivity;
import com.pdamkotamadiun.aduin.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "HomeActivity";

    ActivityHomeBinding mActivityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setClickListener();
    }

    private void setClickListener() {
        mActivityHomeBinding
                .activityHomeCardViewListPengaduan
                .setOnClickListener(v -> startActivity(
                        new Intent(HomeActivity.this, ListPengaduanActivity.class))
                );
        mActivityHomeBinding
                .activityHomeCardViewGrafikRecord
                .setOnClickListener(v -> startActivity(
                        new Intent(HomeActivity.this, GraphOverviewActivity.class)
                ));
    }
}
