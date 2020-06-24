package com.khairy.core.helpers.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

/**
 * Created by Mohamed Khaled on Tue, 30/Oct/2018 at 12:54 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public abstract class BaseListAdapter<T> extends ListAdapter<T, DataBindingViewHolder<T>> {
    public BaseListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    private ViewDataBinding binding;
    private Context context;

    @NonNull
    @Override
    public DataBindingViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater =
                LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataBindingViewHolder<T> holder, int position) {
        holder.bind(getItem(position));
        holder.bind(this);
    }

    protected ViewDataBinding getBindingClass() {
        return binding;
    }

    public Context getContext() {
        return context;
    }
    @Override
    protected T getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract int getLayoutIdForPosition(int position);
}
