package com.prathameshmore.git_notebook.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prathameshmore.git_notebook.MainActivity;
import com.prathameshmore.git_notebook.R;

public class SlashScreen extends AppCompatActivity {

    private static int SPASH_SCREEN_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent flashScreenIntent = new Intent(SlashScreen.this,MainActivity.class);
                startActivity(flashScreenIntent);
                finish();
            }
        },SPASH_SCREEN_TIMEOUT);

    }
}
