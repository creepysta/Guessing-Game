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
        context = this;
    }

    public void onSelectAnimal(View view) {
        Intent intent = new Intent(context, AnimalMode.class);
        startActivity(intent);
    }

    public void onSelectFlower(View view) {
        Intent intent = new Intent(context, FlowerMode.class);
        startActivity(intent);
    }

}
