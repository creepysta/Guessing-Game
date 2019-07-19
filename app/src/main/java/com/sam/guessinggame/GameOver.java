package com.sam.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    private TextView yourScore;
    private TextView highScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_over);

        yourScore = findViewById(R.id.your_score_tv);
        highScore = findViewById(R.id.high_score_tv);
    }

    public void playAgain(View view) {

    }

    public void exitGame(View view) {
        onDestroy();
    }

    public void leaderBoard(View view) {
        Intent intent = new Intent(this, LeaderBoard.class);
        startActivity(intent);
    }

}
