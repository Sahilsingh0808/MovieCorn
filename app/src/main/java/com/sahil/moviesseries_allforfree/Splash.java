package com.sahil.moviesseries_allforfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH_TOTAL = 7000;
    private final int SPLASH_DISPLAY_LENGTH_LOGO = 3700;
    private ImageView splashscreen;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        splashscreen=(ImageView)findViewById(R.id.splashscreen);

        splashscreen.animate().alpha(1).setDuration(3000);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                splashscreen.animate().alpha(0).setDuration(700);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                splashscreen.setImageResource(R.drawable.moviecorn);
                splashscreen.animate().alpha(1).setDuration(3000);
            }
        }, SPLASH_DISPLAY_LENGTH_LOGO);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH_TOTAL);

    }
}