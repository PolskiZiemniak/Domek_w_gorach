package com.example.domekwgrach;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button like;
    private Button delete;
    private TextView likeCounter;
    private Resources res;
    private int likeCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like);
        delete = findViewById(R.id.delete);
        likeCounter = findViewById(R.id.likeCounter);
        res = getResources();

        updateCounter();

        like.setOnClickListener(view -> {
            likeCount++;
            updateCounter();
        });
        delete.setOnClickListener(view -> {
            if(likeCount >= 0) {
                likeCount--;
            }
            updateCounter();
        });

    }
    public void updateCounter(){
        String counter = res.getString(R.string.stringLikeCount, String.valueOf(likeCount));
        likeCounter.setText(counter);
    }
}