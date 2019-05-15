package com.example.bjit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getDatabase(this);

        User user1=new User();
        user1.firstName="Samrat";
        user1.lastName="Hasan";
        User user2=new User();
        user2.firstName="Arshan";
        user2.lastName="Hasan";

        List<User> users= new ArrayList<>();
        users.add(user1);
        db.userDao().insertAll(user1);
        db.userDao().insertAll(user2);

        User read=db.userDao().findByName("Samrat","Hasan");

        Toast.makeText(this,read.firstName+" "+ read.lastName,Toast.LENGTH_LONG).show();

    }
}
