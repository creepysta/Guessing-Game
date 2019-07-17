package com.sam.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private EditText name_et;
    private EditText pass_et;
    private Button login_bt;
    private Button reg_bt;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_main_et);
        pass_et = findViewById(R.id.pass_main_et);
        login_bt = findViewById(R.id.login_main_bt);
        reg_bt = findViewById(R.id.reg_main_bt);

        context = this;

    }

    public void loginAction(View view) {

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Player> playerAccnt = realm.where(Player.class).equalTo("name", name_et.getText().toString()).and().equalTo("pass", pass_et.getText().toString()).findAll();
        if(playerAccnt.size() == 1) {
            Intent intent = new Intent(context, ModeSelection.class);
            startActivity(intent);
        }

    }

    public void regAction(View view) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        try{
            RealmResults<Player> id = realm.where(Player.class).equalTo("name", name_et.getText().toString()).findAll();
            if (id.size() != 0) {
//                Toast.makeText(context, "USERNAME: " + name_et.getText().toString() + " already exists.", Toast.LENGTH_SHORT).show();
                throw new Exception("USERNAME: " + name_et.getText().toString() + " already exists.");

            }

            Player player = realm.createObject(Player.class, System.currentTimeMillis() / 1000);
            player.setName(name_et.getText().toString());
            player.setPassword(pass_et.getText().toString());

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
