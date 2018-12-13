package com.pdamkotamadiun.aduin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.pdamkotamadiun.aduin.R;
import com.pdamkotamadiun.aduin.constant.Constant;
import com.pdamkotamadiun.aduin.databinding.ItemListPengaduanBinding;
import com.pdamkotamadiun.aduin.model.keluhan.Datum;
import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;

public class ListPengaduanViewHolder extends SortedListAdapter.ViewHolder<Datum> {

    private ItemListPengaduanBinding mItemListPengaduanBinding;
    private Context context;

    ListPengaduanViewHolder(Context context, ItemListPengaduanBinding mItemListPengaduanBinding) {
        super(mItemListPengaduanBinding.getRoot());
        this.mItemListPengaduanBinding = mItemListPengaduanBinding;
        this.context = context;
    }


    @Override
    protected void performBind(@NonNull Datum item) {
        if (getLayoutPosition() %2 == 1) {
            mItemListPengaduanBinding.activityItemListPengaduanCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.light_white));
        } else {
            mItemListPengaduanBinding.activityItemListPengaduanCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }

        String status = item.getStatus().getStatus().toUpperCase();
        TextView statusTextView = mItemListPengaduanBinding.activityItemMainTextViewStatus;

        if (status.equals(Constant.DITERIMA)) {
            statusTextView.setTextColor(ContextCompat.getColor(context, R.color.info));
        }
        if (status.equals(Constant.PENGERJAAN)) {
            statusTextView.setTextColor(ContextCompat.getColor(context, R.color.warning));
        }
        if (status.equals(Constant.SELESAI)) {
            statusTextView.setTextColor(ContextCompat.getColor(context, R.color.success));
        }

        mItemListPengaduanBinding.setKeluhan(item);
    }
}
