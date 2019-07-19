package com.sam.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private EditText name_et;
    private EditText pass_et;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_main_et);
        pass_et = findViewById(R.id.pass_main_et);

        context = this;

    }

    public void loginAction(View view) {

//        Intent intent = new Intent(this,GameOver.class);
//        startActivity(intent);

        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<Player> playerAccnt = realm.where(Player.class).equalTo("name", name_et.getText().toString()).and().equalTo("pass", pass_et.getText().toString()).findAll();
            if (playerAccnt.size() == 1) {
                Intent intent = new Intent(context, ModeSelection.class);
                startActivity(intent);
            } else {
                setContentView(R.layout.activity_main);
                Toast.makeText(context, "Username and password doesn't match.", Toast.LENGTH_SHORT).show();
            }
        } catch(Exception e) {
            Toast.makeText(context, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void regAction(View view) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        try{
            RealmResults<Player> id = realm.where(Player.class).equalTo("name", name_et.getText().toString()).findAll();
            if (id.size() != 0) {
                throw new Exception("USERNAME: " + name_et.getText().toString() + " already exists.");

            }

            Player player = realm.createObject(Player.class, System.currentTimeMillis() / 1000);
            player.setName(name_et.getText().toString());
            player.setPass(pass_et.getText().toString());

            realm.commitTransaction();

            Intent intent = new Intent(context, ModeSelection.class);
            startActivity(intent);

        } catch (Exception e) {
            realm.cancelTransaction();
            Toast.makeText(context, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        realm.close();

    }

}
