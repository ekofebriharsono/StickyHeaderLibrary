package com.maseko.root.stickyheaderlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (viewType == Common.VIEW_TYPE_GROUP) {
            ViewGroup group = (ViewGroup) layoutInflater.inflate(R.layout.group_layout, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        } else if (viewType == Common.VIEW_TYPE_PERSON) {
            ViewGroup group = (ViewGroup) layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(group);
            return itemViewHolder;
        } else {
            ViewGroup group = (ViewGroup) layoutInflater.inflate(R.layout.group_layout, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return personList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof GroupViewHolder) {
            GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
            groupViewHolder.txtHeader.setText(personList.get(i).getName());
            groupViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity) context).startActivityForResult(new Intent(context, AlphabetActivity.class), Common.RESULT_CODE);
                }
            });
        } else if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.txtTitle.setText(personList.get(i).getName());
            itemViewHolder.txtSubtitle.setText(personList.get(i).getPosition());

            ColorGenerator colorGenerator = ColorGenerator.MATERIAL;
            TextDrawable drawable = TextDrawable.builder().buildRound(String.valueOf(personList.get(i).getName().charAt(0)), colorGenerator.getRandomColor());

            itemViewHolder.img.setImageDrawable(drawable);
        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    private class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView txtHeader;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHeader = itemView.findViewById(R.id.header);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtSubtitle;
        ImageView img;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.title);
            txtSubtitle = itemView.findViewById(R.id.subtitle);
            img = itemView.findViewById(R.id.img);
        }
    }
}
