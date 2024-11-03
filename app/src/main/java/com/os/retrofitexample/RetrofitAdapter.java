package com.os.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.os.retrofitexample.databinding.DataSingleItemBinding;

import java.util.List;


public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MyViewHolder>{
    List<ModelClass> list;
    Context context;


    public RetrofitAdapter(List<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataSingleItemBinding binding = DataSingleItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvUserId.setText("" + list.get(position).getUserId());
        holder.binding.tvTitle.setText("" + list.get(position).getTitle());
        holder.binding.tvId.setText("" + list.get(position).getId());
        holder.binding.tvBody.setText("" + list.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        DataSingleItemBinding binding;
        public MyViewHolder(DataSingleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
