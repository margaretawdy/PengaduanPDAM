package com.pdamkotamadiun.aduin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.pdamkotamadiun.aduin.databinding.ItemListPengaduanBinding;
import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;

import java.util.Comparator;

public class ListPengaduanAdapter extends SortedListAdapter<Keluhan> {

    private Context context;

    public ListPengaduanAdapter(@NonNull Context context, @NonNull Class<Keluhan> itemClass, @NonNull Comparator<Keluhan> comparator) {
        super(context, itemClass, comparator);
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder<? extends Keluhan> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, int viewType) {
        final ItemListPengaduanBinding itemListPengaduanBinding = ItemListPengaduanBinding.inflate(inflater, parent, false);
        return new ListPengaduanViewHolder(context, itemListPengaduanBinding);
    }
}
