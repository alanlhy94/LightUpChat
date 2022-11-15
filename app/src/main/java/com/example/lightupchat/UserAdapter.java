package com.example.lightupchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHodler> {

    private Context context;
    private List<UserModel> userModelList;

    public UserAdapter(Context context){
        this.context = context;
        userModelList = new ArrayList<>();
    }

    public void add(UserModel userModel)
    {
        userModelList.add(userModel);
        notifyDataSetChanged();
    }

    public void clear(){
        userModelList.clear();
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        UserModel userModel = userModelList.get(position);
        holder.name.setText(userModel.getUserName());
        holder.email.setText(userModel.getUseremail());
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder{
        private TextView name, email;
        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.userEmail);
        }
    }

}
