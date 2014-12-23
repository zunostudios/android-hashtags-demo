package com.zuno.linkdemo;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private String[] names = {"AboveSlipk","Alexify","Anitararo","Arezance",
                              "Candbric","Chickerna","ChirpMarcs","Choraxio","Coolucouse",
                              "Czardion","DariIzZero","Dreamergy","Fantasynell","Girleyerbo",
                              "Goldani","Indategr","Jaeckta","LabsHannahHello","LetterMel","LinkFighter",
                              "Narrativera","Packhozoist","Punkeniamo","QuickXp","RidaSummerGodzilla",
                              "Rockfish","RozFirst","Specialgi","Starusinor","StrongerMania"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

        ArrayList<Comment> comments = new ArrayList<Comment>();
        LoremIpsum loremIpsum = new LoremIpsum();


        for(int i = 0; i < 30; i++) {
            comments.add(
                    new Comment(
                        names[i],
                        loremIpsum.getWords( (int)(Math.random() * 24) + 5)
                    )
            );
        }

        CommentsAdapter adapter = new CommentsAdapter(comments, this);
        ListView commentsList = (ListView) this.findViewById(R.id.comment_list);
        commentsList.setAdapter(adapter);


    }

}
