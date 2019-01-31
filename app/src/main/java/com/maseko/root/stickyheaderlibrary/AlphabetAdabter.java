package com.maseko.root.stickyheaderlibrary;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

public class AlphabetAdabter extends RecyclerView.Adapter<AlphabetAdabter.viewHolder> {

    Context context;
    List<String> alphabetList;

    public void setiOnAlphabetClickListener(IOnAlphabetClickListener iOnAlphabetClickListener) {
        this.iOnAlphabetClickListener = iOnAlphabetClickListener;
    }

    IOnAlphabetClickListener iOnAlphabetClickListener;


    public AlphabetAdabter() {
       alphabetList = Common.getAlphabet();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.alphabet_item, viewGroup, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int i) {
        TextDrawable drawable;
        final int available_position = Common.alphabet_available.indexOf(alphabetList.get(i));

        if (available_position != -1){
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i), Color.GREEN);
        } else {
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i), Color.GRAY);
        }

        viewHolder.imgAvatar.setImageDrawable(drawable);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnAlphabetClickListener.onAlphabetCLickListener(alphabetList.get(i),i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return alphabetList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.alphabet_avatar);
        }
    }
}
