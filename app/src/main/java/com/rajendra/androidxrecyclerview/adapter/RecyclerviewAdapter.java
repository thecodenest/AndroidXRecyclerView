package com.rajendra.androidxrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.androidxrecyclerview.ItemAnimation;
import com.rajendra.androidxrecyclerview.R;
import com.rajendra.androidxrecyclerview.model.UserData;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {

    Context context;
    List<UserData> userDataList;
    List<UserData> filteredUserDataList;

    public RecyclerviewAdapter(Context context, List<UserData> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
        this.filteredUserDataList = userDataList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row_item, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.userName.setText(filteredUserDataList.get(position).getUserName());
        holder.userDesc.setText(filteredUserDataList.get(position).getDescp());
        holder.userImage.setImageResource(filteredUserDataList.get(position).getImageUrl());

        ItemAnimation.animateFadeIn(holder.itemView, position);


    }

    @Override
    public int getItemCount() {
        return filteredUserDataList.size();
    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {


        CircleImageView userImage;
        TextView userName, userDesc;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            userDesc = itemView.findViewById(R.id.userDesc);


        }
    }

    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredUserDataList = userDataList;
                }
                else{

                    List<UserData> lstFiltered = new ArrayList<>();
                    for(UserData row: userDataList){
                        if(row.getUserName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }
                    }

                    filteredUserDataList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUserDataList = (List<UserData>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }


}
