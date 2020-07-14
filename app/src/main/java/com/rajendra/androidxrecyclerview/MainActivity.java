package com.rajendra.androidxrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.rajendra.androidxrecyclerview.adapter.RecyclerviewAdapter;
import com.rajendra.androidxrecyclerview.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView userRecycler;
    RecyclerviewAdapter recyclerviewAdapter;
    EditText searchView;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_bar);

        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(new UserData("Anderson Thomas","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_1));
        userDataList.add(new UserData("Adams Green","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_2));
        userDataList.add(new UserData("Laura Michelle","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_3));
        userDataList.add(new UserData("Betty L","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_4));
        userDataList.add(new UserData("Garcia Lewis","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_1));
        userDataList.add(new UserData("Roberts Turner","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_2));
        userDataList.add(new UserData("Mary Jackson","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_3));
        userDataList.add(new UserData("Sarah Scott","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_4));
        userDataList.add(new UserData("Anderson Thomas","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_1));
        userDataList.add(new UserData("Adams Green","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_2));
        userDataList.add(new UserData("Laura Michelle","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_3));
        userDataList.add(new UserData("Betty L","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_male_4));
        userDataList.add(new UserData("Garcia Lewis","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_1));
        userDataList.add(new UserData("Roberts Turner","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_2));
        userDataList.add(new UserData("Mary Jackson","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_3));
        userDataList.add(new UserData("Sarah Scott","Android is awesome and this is the part 3 of recyclerview.", R.drawable.photo_female_4));



        setUserRecycler(userDataList);


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                recyclerviewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private  void  setUserRecycler(List<UserData> userDataList){
        userRecycler = findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(this, userDataList);
        userRecycler.setAdapter(recyclerviewAdapter);
    }

}
