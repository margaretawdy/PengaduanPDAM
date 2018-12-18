package com.pdamkotamadiun.aduin.activity.supervisor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.adapter.ListPengaduanAdapter;
import com.pdamkotamadiun.aduin.databinding.ActivityListPengaduanBinding;
import com.pdamkotamadiun.aduin.model.keluhan.Datum;
import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;
import com.pdamkotamadiun.aduin.service.KeluhanService;
import com.pdamkotamadiun.aduin.utils.RecyclerItemClickSupportUtils;
import com.pdamkotamadiun.aduin.utils.ServiceGeneratorUtils;

import java.util.Comparator;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPengaduanActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SortedListAdapter.Callback {

    private static final String TAG = "ListPengaduanActivity";
    Comparator<Datum> COMPARATOR = new SortedListAdapter.ComparatorBuilder<Datum>()
            .setOrderForModel(Datum.class, (a, b) -> Long.signum(a.getId() - b.getId()))
            .build();

    private ActivityListPengaduanBinding mActivityListPengaduanBinding;
    private Keluhan mKeluhan;
    private Animator mAnimator;
    private ListPengaduanAdapter mListPengaduanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityListPengaduanBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_pengaduan);
        setAdapter();
        getKeluhanList();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onEditStarted() {
        if (mActivityListPengaduanBinding.activityListPengaduanProgressBar.getVisibility() != View.VISIBLE) {
            mActivityListPengaduanBinding.activityListPengaduanProgressBar.setVisibility(View.VISIBLE);
            mActivityListPengaduanBinding.activityListPengaduanProgressBar.setAlpha(0.0f);
        }

        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ObjectAnimator.ofFloat(mActivityListPengaduanBinding.activityListPengaduanProgressBar, View.ALPHA, 1.0f);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.start();

        mActivityListPengaduanBinding.activityListPengaduanRecyclerViewPengaduanMasuk.animate().alpha(0.5f);
    }

    @Override
    public void onEditFinished() {
        mActivityListPengaduanBinding.activityListPengaduanRecyclerViewPengaduanMasuk.scrollToPosition(0);
        mActivityListPengaduanBinding.activityListPengaduanRecyclerViewPengaduanMasuk.animate().alpha(1.0f);

        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ObjectAnimator.ofFloat(mActivityListPengaduanBinding.activityListPengaduanProgressBar, View.ALPHA, 0.0f);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {

            private boolean mCanceled = false;

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                mCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!mCanceled) {
                    mActivityListPengaduanBinding.activityListPengaduanProgressBar.setVisibility(View.GONE);
                }
            }
        });
        mAnimator.start();
    }

    private void setAdapter() {
        mListPengaduanAdapter = new ListPengaduanAdapter(this, Datum.class, COMPARATOR);
    }

    private void getKeluhanList() {
        ServiceGeneratorUtils
                .createService(KeluhanService.class)
                .getKeluhan()
                .enqueue(new Callback<Keluhan>() {
                    @Override
                    public void onResponse(@NonNull Call<Keluhan> call, @NonNull Response<Keluhan> response) {
                        mKeluhan = response.body();
                        if (mKeluhan != null) {
                            Log.d(TAG, "onResponse: " + mKeluhan);
                            if (mKeluhan.isError()) {
                                onLoadKeluhanFailed();
                            } else {
                                onLoadKeluhanSuccess();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Keluhan> call, @NonNull Throwable t) {
                        onLoadKeluhanFailed();
                    }
                });

    }

    private void onLoadKeluhanSuccess() {
        mListPengaduanAdapter.edit().replaceAll(mKeluhan.getData().getData());
    }

    private void onLoadKeluhanFailed() {
    }
}
