package com.memoapp.amol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.AdapterHolder> {
    String title[], body[];
    Context ctx;

    public MemoAdapter(Context ct, String title[], String body[]) {
        ctx = ct;
        this.title = title;
        this.body = body;
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {
        holder.t1.setText(title[position]);
        holder.t2.setText(body[position]);
    }

    @Override
    public MemoAdapter.AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(ctx);
        View v = inflate.inflate(R.layout.memo_layout, parent, false);
        return new AdapterHolder(v);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;

        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.memoTitle);
            t2 = itemView.findViewById(R.id.memoBody);

        }
    }
}
