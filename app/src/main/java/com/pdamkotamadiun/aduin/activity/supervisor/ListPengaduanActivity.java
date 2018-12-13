package com.pdamkotamadiun.aduin.activity.supervisor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.adapter.ListPengaduanAdapter;
import com.pdamkotamadiun.aduin.databinding.ActivityListPengaduanBinding;
import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;
import com.pdamkotamadiun.aduin.model.keluhan.KeluhanResponse;

import java.util.Comparator;
import java.util.List;

public class ListPengaduanActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SortedListAdapter.Callback {

    ActivityListPengaduanBinding mActivityListPengaduanBinding;
    List<KeluhanResponse> mKeluhanResponseList;
    private Animator mAnimator;
    private ListPengaduanAdapter mListPengaduanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityListPengaduanBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_pengaduan);
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

        mAnimator = ObjectAnimator.ofFloat(mActivityListPengaduanBinding.editProgressBar, View.ALPHA, 0.0f);
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
}
