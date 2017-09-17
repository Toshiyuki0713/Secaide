package com.dotinstall.secaide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void health_data (View view) {
        Intent intent = new Intent(this, HealthCareData.class);
        startActivity(intent);
    }

    public void koredake_view (View view) {
        Intent intent = new Intent(this, Koredake.class);
        startActivity(intent);
    }
}
