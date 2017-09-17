package com.dotinstall.secaide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dotinstall.secaide.R;

public class HealthCareData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_data);
    }

    public void koredake_view (View view) {
        Intent intent = new Intent(this, Koredake.class);
        startActivity(intent);
    }

    public void main_view (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
