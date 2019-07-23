package com.sam.guessinggame;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ModeSelection extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_selection);
        context = this;
    }

    public void onSelectAnimal(View view) {
        Bundle cred = getIntent().getBundleExtra("cred");
        Intent intent = new Intent(context, AnimalMode.class);
        intent.putExtra("cred", cred);
        startActivity(intent);
    }

    public void onSelectFlower(View view) {
        Bundle cred = getIntent().getBundleExtra("cred");
        Intent intent = new Intent(context, FlowerMode.class);
        intent.putExtra("cred", cred);
        startActivity(intent);
    }

}
