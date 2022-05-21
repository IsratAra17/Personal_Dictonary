package com.example.personal_dictonary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personal_dictonary.ModelClass.ModelDictionary;
import com.example.personal_dictonary.R;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder> {
    ArrayList<ModelDictionary>modelDictionaryRooms;
    Context context;

    public WordAdapter(ArrayList<ModelDictionary> modelDictionaryRooms, Context context) {
        this.modelDictionaryRooms = modelDictionaryRooms;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_gallery,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.textword.setText(""+modelDictionaryRooms.get(position).getWord());
        holder.textmean.setText(""+modelDictionaryRooms.get(position).getWord());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textword,textmean;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textword=itemView.findViewById(R.id.tword);
            textmean=itemView.findViewById(R.id.tmean);
        }
    }
}
