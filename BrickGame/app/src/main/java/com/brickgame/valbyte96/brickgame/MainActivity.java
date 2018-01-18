package com.brickgame.valbyte96.brickgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        BrickView brickView = (BrickView) findViewById(R.id.brick_view);
        brickView.setUserName(username);
    }

}
