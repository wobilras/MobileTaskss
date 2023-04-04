package com.example.taskss.ui.state_holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskss.R;
import com.example.taskss.data.models.State;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{
    public interface OnStateClickListener{
        void onStateClick(State state, int position);
    }
    public final OnStateClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<State> states;

    public StateAdapter(Context context, List<State> states, OnStateClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        State state = states.get(position);
        holder.carView.setImageResource(state.getCarResource());
        holder.nameView.setText(state.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(state, position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return states.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView carView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            carView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.txt);
        }
    }
}


