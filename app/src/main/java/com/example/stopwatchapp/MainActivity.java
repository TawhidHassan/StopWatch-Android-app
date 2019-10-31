package com.example.stopwatchapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash,tvSubSplash;
    Button btnget;
    ImageView imageView;
    Animation agt,btgone,btgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agt= AnimationUtils.loadAnimation(this,R.anim.agt);
        btgone= AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo= AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        tvSplash=findViewById(R.id.tvSplash);
        tvSubSplash=findViewById(R.id.tvSubSplash);
        btnget=findViewById(R.id.btnget);
        imageView=findViewById(R.id.ivSplash);

        //import fonts
        Typeface MLight=Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMediumt=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular=Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //set fonts
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MMediumt);
        btnget.setTypeface(MLight);

        //animation
        imageView.setAnimation(agt);
        tvSplash.setAnimation(btgone);
        tvSubSplash.setAnimation(btgone);
        btnget.setAnimation(btgtwo);

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StopAct.class);
                startActivity(intent);
            }
        });

    }
}
