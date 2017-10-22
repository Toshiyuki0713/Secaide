package com.dotinstall.secaide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.linecorp.linesdk.api.LineApiClient;

/**
 * Created by gosho on 2017/10/23.
 */

public class Biposi extends AppCompatActivity {

    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        message = intent.getStringExtra("message");

        TextView textView = (TextView) findViewById(R.id.profileName);
        textView.setText(message);

    }

    public void health_data(View view) {
        Intent intent = new Intent(this, HealthCareData.class);
        String str = message.toString();
        intent.putExtra("message", str);
        startActivity(intent);
    }

    public void koredake_view(View view) {
        Intent intent = new Intent(this, Koredake.class);
        String str = message.toString();
        intent.putExtra("message", str);
        startActivity(intent);
    }
}
