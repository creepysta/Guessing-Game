package com.sam.guessinggame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class QuestionFragment extends Fragment {

    private ImageView pic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment,container, false);

        pic = view.findViewById(R.id.picture_fragment);
//        pic.setImageResource(R.drawable.ic_launcher_foreground);
        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .resize(300,300)
                .centerCrop()
                .into(pic);

        return view;

    }

}
