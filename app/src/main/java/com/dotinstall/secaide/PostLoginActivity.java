package com.dotinstall.secaide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.api.LineApiClient;
import com.linecorp.linesdk.api.LineApiClientBuilder;

public class PostLoginActivity extends AppCompatActivity {

    private LineApiClient lineApiClient;
    TextView profileText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineApiClientBuilder apiClientBuilder = new LineApiClientBuilder(getApplicationContext(), Constants.CHANNEL_ID);
        lineApiClient = apiClientBuilder.build();


        Intent intent = getIntent();
        LineProfile intentProfile = intent.getParcelableExtra("line_profile");
        //LineCredential intentCredential = intent.getParcelableExtra("line_credential");



        profileText = (TextView) findViewById(R.id.profileName);
        profileText.setText(intentProfile.getDisplayName() + "さん");
    }

    public void health_data(View view) {
        Intent intent = new Intent(this, HealthCareData.class);
        String str = profileText.getText().toString();
        intent.putExtra("message", str);
        startActivity(intent);
    }

    public void koredake_view(View view) {
        Intent intent = new Intent(this, Koredake.class);
        String str = profileText.getText().toString();
        intent.putExtra("message", str);
        startActivity(intent);
    }


}
