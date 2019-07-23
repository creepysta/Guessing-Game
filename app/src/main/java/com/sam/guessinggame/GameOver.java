package com.sam.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmResults;

public class GameOver extends AppCompatActivity {

    private TextView yourScore;
    private TextView highScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_over);
//        int score = getIntent().getBundleExtra("score").getInt("score");
//        String username = getIntent().getBundleExtra("score").getString("name");

        yourScore = findViewById(R.id.your_score_tv);
        highScore = findViewById(R.id.high_score_tv);

//        Player player = Realm.getDefaultInstance().where(Player.class).equalTo("name", username).findFirst();
//        int maxScore = player.getMax_score();
//        yourScore.setText(score);
//        highScore.setText(maxScore);
    }

    public void playAgain(View view) {

        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
//        finish();

    }

    public void exitGame(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("exit", true);
        startActivity(intent);

    }

    public void leaderBoard(View view) {
        Intent intent = new Intent(this, LeaderBoard.class);
        startActivity(intent);
    }

}
