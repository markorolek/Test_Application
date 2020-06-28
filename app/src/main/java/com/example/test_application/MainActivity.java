package com.example.test_application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.tv_list);
        String[] names = {"Java", "Python", "C++", "Matlab", "Go", "C", "Swift", "JavaScript", "Ruby", "PHP", "Perl", "C#"};

        list.setText("");
        for(String name:names){
            list.append(name + "\n");
        }
    }
}