package com.example.smartposture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smartposture.MainActivity;
import com.example.smartposture.R;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread=new Thread(){
            public void run(){

                try {
                    sleep(4000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                    startActivity(intent);
                }
            }

        };thread.start();
    }
}