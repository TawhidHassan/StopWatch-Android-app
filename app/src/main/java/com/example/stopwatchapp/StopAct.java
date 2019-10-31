package com.example.stopwatchapp;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

public class StopAct extends AppCompatActivity {

    Button btnget,btnend;
    ImageView icanchor;
    Animation roundingalone,routestop;
    Chronometer timehere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        roundingalone= AnimationUtils.loadAnimation(this,R.anim.roundingalone);
        routestop= AnimationUtils.loadAnimation(this,R.anim.routestop);
        btnget=findViewById(R.id.btnget);
        btnend=findViewById(R.id.btnend);
        icanchor=findViewById(R.id.icachon);
        timehere=findViewById(R.id.timeHere);

        btnend.setAlpha(0);

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                btnend.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnget.animate().alpha(0).setDuration(300).start();

                timehere.setBase(SystemClock.elapsedRealtime());
                timehere.start();

                Toast.makeText(getApplicationContext(),"work",Toast.LENGTH_LONG).show();
            }
        });

        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(routestop);
                btnend.animate().alpha(0).setDuration(300).start();
                btnget.animate().alpha(1).translationY(80).setDuration(300).start();
                timehere.setBase(SystemClock.elapsedRealtime());
                timehere.stop();

                Toast.makeText(getApplicationContext(),"Stop work",Toast.LENGTH_LONG).show();
            }
        });



    }
}
