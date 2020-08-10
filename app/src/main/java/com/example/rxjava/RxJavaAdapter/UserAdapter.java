package com.example.rxjava.RxJavaAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlearning.RxJavaModel.User;
import com.example.androidlearning.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> usersList;

    public UserAdapter( List<User> usersList) {
        super();
        this.usersList = usersList;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rxjava_user_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.userId.setText(String.valueOf(usersList.get(position).id));
        holder.firstName.setText(usersList.get(position).firstname);
        holder.lastName.setText(new StringBuilder(usersList.get(position).lastname));

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView userId;
        public TextView firstName;
        public TextView lastName;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_id);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);

        }
    }
}
