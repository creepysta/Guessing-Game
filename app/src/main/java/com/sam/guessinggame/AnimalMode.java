package com.sam.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmResults;

public class AnimalMode extends AppCompatActivity {

    private Context context;

    private GestureDetectorCompat detector;
    private ImageView pic;
    private Button op[] = new Button[4];
    private TextView remGuesses;

    String userName;

    private int k;
    private int score;
    private int guesses;

    private String options_num[] = {"A. ", "B. ", "C. " , "D. "};
    private int randomList[] = new int[25];
    private String userIp = "";


    private String animalList[] = new String[]{"https://d3td2int7n7fhj.cloudfront.net/sites/default/files/styles/crop_15_10_480x320/public/media/image/2019-03/Ears.jpg?h=b3660f0d&itok=VAccN0j9",
            "https://api.discovery.com/v1/images/5806773e6b66d16e0774d74e?aspectRatio=16x9&width=462&key=3020a40c2356a645b4b4",
            "https://www.thegazette.com/storyimage/GA/20180918/ARTICLE/180919653/AR/0/AR-180919653.jpg&MaxH=500&MaxW=900",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ_CNJ6Ch_HktWWp-emsMLrOsU_Qiot1i9IhYIBOYWHgYcUjuSUA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMSOR55R_9g9Az9GOdRjVrnEu2kRKne8zsYkWX2XSILD7Vnhyu",
            "https://media.wired.com/photos/5bfde7b13ee8d605f3dd0edf/4:3/w_1040,c_limit/fallshow-01.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVhWOAnKCp7gU3B9vLRItzXsj00bXQV1_DDdP5ZSCvMvDfr9LD6Q",
            "https://previews.123rf.com/images/giedriius/giedriius1712/giedriius171200213/92068702-portrait-of-a-cute-red-fox-in-the-garden-full-of-flowers-urban-wildlife-.jpg",
            "https://blog.humanesociety.org/wp-content/uploads/2018/09/DSC_0004_171207-e1537549082632-1220x812.jpg",
            "https://switchzoo.com/images/zebra_scene.jpg",
            "https://images.thewest.com.au/publication/B881216027Z/1559195664672_G30285UD2.1-2.jpg",
            "https://guidetoiceland.imgix.net/336316/x/0/wildlife-and-animals-in-iceland-1?auto=compress%2Cformat&ch=Width%2CDPR&dpr=1&h=630&ixlib=php-3.0.0&w=1200&s=7693c13a555a139df96b8b390960aa10",
            "https://media.istockphoto.com/photos/mountain-goat-portrait-picture-id503787928?k=6&m=503787928&s=612x612&w=0&h=VGG8IPJqrpaSgCjFjbto3XmuH4kbtMdHzZ1uLNc5OF8=",
            "https://vignette.wikia.nocookie.net/cultivation-chat-group/images/1/15/Sea-turtle2.jpg/revision/latest?cb=20180223033704",
            "https://english.cdn.zeenews.com/sites/default/files/2014/12/16/303313-rhino.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRkbw4iHty81TWeSClcMNdcQK8oV4IebRr1Qlt0aBBGhbSU41eaw",
            "https://s.blogcdn.com/travel.aol.co.uk/media/2013/08/croc.jpg",
            "http://thetyee.ca/Culture/2017/10/31/FawnLawn.jpg",
            "http://nie-images.s3.amazonaws.com/gall_content/2019/5/2019_5$largeimg23_May_2019_150004723.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxz9kZdO1VtVSeFO_-nbBDU1oHEaytPZ3vC4YYkZsgoKvTmn9x",
            "https://i.etsystatic.com/14469916/r/il/7df3e1/1442358316/il_794xN.1442358316_gnvt.jpg",
            "https://cdn.britannica.com/s:500x350/06/150806-004-5BC4AE28.jpg",
            "https://earthnworld.com/wp-content/uploads/2018/10/Golden-Lion-Tamarin.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Red_Colobus_7.jpg/1200px-Red_Colobus_7.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRXtV_Dn2yOm-PC-OanrMISnbrGQaC0fu3ClMeeW7kXk_fz5FbHg",
            "https://qph.fs.quoracdn.net/main-qimg-565f7217e2e48b9844f6d7de6219ac1b",
            "https://c402277.ssl.cf1.rackcdn.com/photos/479/images/story_full_width/giant-panda-shutterstock_86500690.jpg?1345572346",
            "https://i.pinimg.com/originals/aa/34/7a/aa347afac4f9604854ba8a08801f527f.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/1200px-Cat_November_2010-1a.jpg",
            "https://cdn.anythingpawsable.com/uploads/2013/07/Dog-Pinscher-Laying-Down.jpg",
            "https://www.pets4homes.co.uk/images/breeds/56/9b8f8158056fc5420a03372c9772678e.jpeg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCyRDsFwVjQ4Po4bHLHJqpCpurot0d2exEJFWXNo_-Da4a2N8R",
            "https://www.dogbreedslist.info/uploads/allimg/dog-pictures/Siberian-Husky-1.jpg",
            "https://www.ctvsh.com/sites/default/files/styles/large/adaptive-image/public/german-shepherd-dog-breed-info.jpg?itok=mPeDrQWU",
            "https://d17fnq9dkz9hgj.cloudfront.net/breed-uploads/2018/08/beagle-detail.jpg?bust=1535565158&width=355",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXmoZN-IzR8UY3NO6Eq83mypQWfninSqaJDWciI9zn9urWLIen",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGZ8oIEk6KNCL1uk-ibLbRpLKdXMlIcibki8_gjR2ZT5Vfppo",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/17154200/Boxer.1.jpg",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12234114/Dachshund-On-White-01.jpg",
            "https://d17fnq9dkz9hgj.cloudfront.net/breed-uploads/2018/08/poodle-detail.jpg?bust=1535566339&width=355",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12224329/Shih-Tzu-On-White-01.jpg",
            "https://cdn3-www.dogtime.com/assets/uploads/gallery/chow-chow-dog-breed-pictures/3-fullbody.jpg",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12234710/Chihuahua-On-White-03.jpg",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12225627/Pomeranian-On-White-01.jpg",
            "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/13000402/Bichon-Frise-On-White-03.jpg",
            "https://www.dogexpress.in/wp-content/uploads/2016/02/Dalmatian-1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Mugger_crocodile_Crocodylus_palustris_%282155269175%29.jpg/1200px-Mugger_crocodile_Crocodylus_palustris_%282155269175%29.jpg",
            "https://3c1703fe8d.site.internapcdn.net/newman/csz/news/800/2017/endangeredcu.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Siamcroc.JPG/220px-Siamcroc.JPG",
            "https://live.staticflickr.com/4508/37041005493_373d54450a_b.jpg"};

    private String options[][] = new String[][]{{"Lion","Cow","Tiger","Rabbit"},
        {"Lion","Monkey","Rabbit","Tiger"},
        {"Dog","Monkey","Rabbit","Tiger"},
        {"Dog","Monkey","Elephant","Lion"},
        {"Gorilla","Monkey","Elephant","Lion"},
        {"Gorilla","Monkey","Elephant","Tiger"},
        {"Giraffe","Dog","Monkey","Rabbit"},
        {"Giraffe","Gorilla","Fox","Elephant"},
        {"Camel","Gorilla","Fox","Elephant"},
        {"Zebra","Camel","Gorilla","Fox"},
        {"Kangaroo","Zebra","Camel","Gorilla"},
        {"Polar Bears","Kangaroo","Zebra","Camel"},
        {"Mountain Goat","Polar Bears","Kangaroo","Zebra"},
        {"Turtle","Polar Bears","Kangaroo","Zebra"},
        {"Rhinoceros","Monkey","Rabbit","Tiger"},
        {"Sheep","Rhinoceros","Monkey","Rabbit"},
        {"Crocodile","Rhinoceros","Monkey","Rabbit"},
        {"Deer","Monkey","Rabbit","Tiger"},
        {"Koala Bear","Cow","Tiger","Rabbit"},
        {"Black Faced Monkey","Cow","Tiger","Rabbit"},
        {"Langur Monkey","Lion","Rabbit","Tiger"},
        {"Proboscis Monkey","Koala Bear","Cow","Tiger"},
        {"Golden Lion Tamarin","Koala Bear","Cow","Tiger"},
        {"Red Colobus","Lion","Rabbit","Tiger"},
        {"Pygmy Marmoset","Lion","Rabbit","Tiger"},
        {"Pygmy Marmoset","Lion","Rabbit","Mandrill"},
        {"Giant Panda","Lion","Rabbit","Mandrill"},
        {"Giant Panda","Lion","Rabbit","Red Panda"},
        {"Tabby Cat","Lion","Rabbit","Red Panda"},
        {"Doberman","Camel","Gorilla","Fox"},
        {"Camel","Gorilla","Fox","Bulldog"},
        {"Camel","Gorilla","Fox","Golden Retriever"},
        {"Siberian Husky","Camel","Gorilla","Fox"},
        {"Camel","Gorilla","Fox","German Shepherd"},
        {"Beagle","Camel","Gorilla","Fox"},
        {"Great Dane","Camel","Gorilla","Fox"},
        {"Camel","Gorilla","Fox","Rottweiler"},
        {"Camel","Gorilla","Fox","Boxer"},
        {"Dachshund","Gorilla","Fox","Boxer"},
        {"Gorilla","Fox","Boxer","Poodle"},
        {"Gorilla","Fox","Boxer","Shih Tzu"},
        {"Chow Chow","Fox","Boxer","Shih Tzu"},
        {"Fox","Boxer","Shih Tzu","Chihuahua"},
        {"Gorilla","Fox","Boxer","Pomeranian"},
        {"Gorilla","Fox","Boxer","Bichon Frise"},
        {"Dalmatian","Fox","Boxer","Poodle"},
        {"Fox","Boxer","Poodle","Marsh Crocodile"},
        {"Fox","Boxer","Poodle","Cuban Crocodile"},
        {"Fox","Boxer","Poodle","Siamese Crocodile"},
        {"Fox","Boxer","Poodle","Grevy's Zebra"}};
    private String ans[] = new String[]{"Rabbit",
            "Lion",
            "Dog",
            "Elephant",
            "Gorilla",
            "Tiger",
            "Giraffe",
            "Fox",
            "Camel",
            "Zebra",
            "Kangaroo",
            "Polar Bears",
            "Mountain Goat",
            "Turtle",
            "Rhinoceros",
            "Sheep",
            "Crocodile",
            "Deer",
            "Koala Bear",
            "Black Faced Monkey",
            "Langur Monkey",
            "Proboscis Monkey",
            "Golden Lion Tamarin",
            "Red Colobus",
            "Pygmy Marmoset",
            "Mandrill",
            "Giant Panda",
            "Red Panda",
            "Tabby cat",
            "Doberman",
            "Bulldog",
            "Golden Retriever",
            "Siberian Husky",
            "German Shepherd",
            "Beagle",
            "Great Dane",
            "Rottweiler",
            "Boxer",
            "Dachshund",
            "Poodle",
            "Shih Tzu",
            "Chow Chow",
            "Chihuahua",
            "Pomeranian",
            "Bichon Frise",
            "Dalmatian",
            "Marsh Crocodile",
            "Cuban Crocodile",
            "Siamese Crocodile",
            "Grevy's Zebra"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_mode);

        // initialising components
        context = this;
        detector = new GestureDetectorCompat(this, new GestureListener());
        pic = findViewById(R.id.picture_fragment);
        op[0] = findViewById(R.id.op1);
        op[1] = findViewById(R.id.op2);
        op[2] = findViewById(R.id.op3);
        op[3] = findViewById(R.id.op4);
        remGuesses = findViewById(R.id.rem_guess);


        // getting user name
        Bundle b = getIntent().getBundleExtra("cred");
        userName = b.getString("name");


        // initialising k, guess and score
        k = 0;
        score = 0;
        guesses = 5;

        remGuesses.setText(String.valueOf(guesses));
        // creating the randomList to fetch corresponding pics
        for(int i = 0; i < 25; i++) {
            randomList[i] = (int) (Math.random() * animalList.length) % animalList.length;
        }


        changeQuestion();

    pic.setOnTouchListener(touchListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return detector.onTouchEvent(motionEvent);
        }
    };

    class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(k < 24 && guesses > 0) {

                guesses -= 1;
                k += 1;
                remGuesses.setText(String.valueOf(guesses));


                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Player player = realm.where(Player.class).equalTo("name", userName).findFirst();
                player.setRecentScore(score);
                if(player.getRecentScore() > player.getMax_score()) {
                    player.setMax_score(player.getRecentScore());
                }
                realm.commitTransaction();
                realm.close();

                changeQuestion();

            } else {
                gameOver();
            }


            return true;
        }


    }


    public void optionA(View view) {

        userIp = options[randomList[k]][0];

        operation(userIp);
    }

    public void optionB(View view) {

        userIp = options[randomList[k]][1];

        operation(userIp);
    }

    public void optionC(View view) {

        userIp = options[randomList[k]][2];

        operation(userIp);
    }

    public void optionD(View view) {

        userIp = options[randomList[k]][3];

        operation(userIp);
    }

    public void operation(String ip) {
        if(ans[randomList[k]] == ip) {
            score += 5;
        } else {
            if(score >= 5) {
                score -= 5;
            }
        }

        if(k < 24 && guesses > 0) {
            k++;
            changeQuestion();


        } else {
            gameOver();
        }

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Player player = realm.where(Player.class).equalTo("name", userName).findFirst();
        player.setRecentScore(score);
        if(player.getRecentScore() > player.getMax_score()) {
            player.setMax_score(player.getRecentScore());
        }

//        Toast.makeText(this, score + " " + ans[randomList[k]] + " " + k, Toast.LENGTH_SHORT).show();
        realm.commitTransaction();
        realm.close();
    }

    public void changeQuestion() {
        Picasso.get()
                .load(animalList[randomList[k]])
                .resize(300,300)
                .centerCrop()
                .into(pic);



        for(int i = 0; i < 4; i++) {
            op[i].setText(options_num[i] + options[randomList[k]][i]);
        }

    }

    public void gameOver() {

        Intent intent = new Intent(this, GameOver.class);
        Bundle b = new Bundle();
        b.putInt("score", score);
        b.putString("name", userName);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

}
