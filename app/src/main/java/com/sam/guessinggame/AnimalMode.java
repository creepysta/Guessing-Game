package com.sam.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmResults;

public class AnimalMode extends AppCompatActivity {

    private Context context;

    private ImageView pic;
    private Button op[] = new Button[4];
    private TextView remGuesses;

    private int k;
    private int score;
    private int guesses;

    private String options_num[] = {"A. ", "B. ", "C. " , "D. "};

    private String animalList[] = new String[100];
    private int randomList[] = new int[25];
    private String userIp = "";
    private String options[][] = new String[100][4];
    private String ans[] = new String[100];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_mode);

        // initialising components
        context = this;
        pic = findViewById(R.id.picture_fragment);
        op[0] = findViewById(R.id.op1);
        op[1] = findViewById(R.id.op2);
        op[2] = findViewById(R.id.op3);
        op[3] = findViewById(R.id.op4);
        remGuesses = findViewById(R.id.rem_guess);

        // setting the options for all the image set
        options[0][0] = "elephant";
        options[0][1] = "zebra";
        options[0][2] = "dog";
        options[0][3] = "koala";

        // setting the answer to respective figs
        ans[0] = "elephant";

        // initialising k, guess and score
        k = 0;
        score = 0;
        guesses = 3;

        // creating the randomList to fetch corresponding pics
        for(int i = 0; i < 25; i++) {
            randomList[i] = (int) Math.random() % 100;
        }

        // creating the animalList
        animalList[0] = ("http://i.imgur.com/DvpvklR.png");
        animalList[1] = ("https://i.imgur.com/PpaTSHyb.jpg");
        animalList[2] = ("https://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x20/sample_images/img/index/ff_x20_008.JPG");
        animalList[3] = "https://4.img-dpreview.com/files/p/E~TS590x0~articles/3925134721/0266554465.jpeg";
        Picasso.get()
                .load(animalList[randomList[k]])
                .resize(300,300)
                .centerCrop()
                .into(pic);



        for(int i = 0; i < 4; i++) {
            op[i].setText(options_num[i] + options[k][i]);
        }

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.questions_holder_animal, new QuestionFragment());
//        ft.commit();

    }

    public void optionA(View view) {

        userIp = op[0].getText().toString();

        if(ans[randomList[k]] == userIp) {
            score += 5;
        }

        if(k < 25) {
            k++;
            Picasso.get()
                    .load(animalList[k])
                    .resize(300, 300)
                    .centerCrop()
                    .into(pic);


            for(int i = 0; i < 4; i++) {
                op[i].setText(options_num[i] + options[k][i]);
            }

        } else {
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }

//        Realm realm = Realm.getDefaultInstance();
//        RealmResults<Player> playerResult = realm.where(Player.class)

    }

    public void optionB(View view) {

        userIp = op[1].getText().toString();

        if(ans[randomList[k]] == userIp) {
            score += 5;
        }

        if(k < 25) {
            k++;
            Picasso.get()
                    .load(animalList[k])
                    .resize(300, 300)
                    .centerCrop()
                    .into(pic);


            for(int i = 0; i < 4; i++) {
                op[i].setText(options_num[i] + options[k][i]);
            }

        } else {
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }

    public void optionC(View view) {

        userIp = op[3].getText().toString();

        if(ans[randomList[k]] == userIp) {
            score += 5;
        }

        if(k < 25) {
            k++;
            Picasso.get()
                    .load(animalList[k])
                    .resize(300, 300)
                    .centerCrop()
                    .into(pic);


            for(int i = 0; i < 4; i++) {
                op[i].setText(options_num[i] + options[k][i]);
            }

        } else {
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }
    public void optionD(View view) {

        userIp = op[3].getText().toString();

        if(ans[randomList[k]] == userIp) {
            score += 5;
        }

        if(k < 25) {
            k++;
            Picasso.get()
                    .load(animalList[k])
                    .resize(300, 300)
                    .centerCrop()
                    .into(pic);


            for(int i = 0; i < 4; i++) {
                op[i].setText(options_num[i] + options[k][i]);
            }

        } else {
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }

}
