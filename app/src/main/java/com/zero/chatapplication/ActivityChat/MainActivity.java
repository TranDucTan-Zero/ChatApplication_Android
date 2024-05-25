package com.zero.chatapplication.ActivityChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zero.chatapplication.ActivityLG_SU.LoginActivity;
import com.zero.chatapplication.ActivityLG_SU.SignUpActivity;
import com.zero.chatapplication.Adapter.UserAdapter;
import com.zero.chatapplication.Helper.UsersClass;
import com.zero.chatapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView mainUserRlV;
UserAdapter adapter;
FirebaseDatabase database;
ImageView logout;
ArrayList<UsersClass> usersClassArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        database = FirebaseDatabase.getInstance();

        usersClassArrayList = new ArrayList<>();

        DatabaseReference reference = database.getReference().child("users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    UsersClass usersClass = dataSnapshot.getValue(UsersClass.class);
                    usersClassArrayList.add(usersClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        logout=  findViewById(R.id.logout);
        mainUserRlV = findViewById(R.id.mainUserRlV);
        mainUserRlV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(MainActivity.this, usersClassArrayList);
        mainUserRlV.setAdapter(adapter);

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.logout_user);

        TextView logout, notlogout;
        logout = dialog.findViewById(R.id.logout);
        notlogout = dialog.findViewById(R.id.notlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        notlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
});
    }
}