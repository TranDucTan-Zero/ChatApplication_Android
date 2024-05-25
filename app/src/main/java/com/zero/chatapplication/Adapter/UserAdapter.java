package com.zero.chatapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zero.chatapplication.ActivityChat.MainActivity;
import com.zero.chatapplication.Helper.UsersClass;
import com.zero.chatapplication.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Viewholder> {
   Context mainActivity;
   ArrayList<UsersClass>usersClassArrayList;
    public UserAdapter(MainActivity mainActivity, ArrayList<UsersClass> usersClassArrayList) {
        this.mainActivity = mainActivity;
        this.usersClassArrayList = usersClassArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_users_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        UsersClass usersClass = usersClassArrayList.get(position);
        holder.user_name.setText(usersClass.getName());
        holder.user_status.setText(usersClass.getStatus());
        Picasso.get().load(usersClass.getImageUri()).into(holder.user_profile);

    }
    @Override
    public int getItemCount() {
        return usersClassArrayList.size();
    }
    class Viewholder extends RecyclerView.ViewHolder{
        CircleImageView user_profile;
        TextView user_name;
        TextView user_status;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            user_profile = itemView.findViewById(R.id.profile_img);
            user_name = itemView.findViewById(R.id.user_name);
            user_status = itemView.findViewById(R.id.user_status);
        }
    }
}
