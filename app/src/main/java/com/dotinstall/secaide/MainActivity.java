package com.dotinstall.secaide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.linecorp.linesdk.auth.LineLoginApi;
import com.linecorp.linesdk.auth.LineLoginResult;

/**
 * Created by gosho on 2017/10/22.
 */

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        final TextView loginButton = (TextView) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                    // App to App Login
                    Intent LoginIntent = LineLoginApi.getLoginIntent(v.getContext(), Constants.CHANNEL_ID);
                    startActivityForResult(LoginIntent, REQUEST_CODE);

                } catch (Exception e) {
                    Log.e("ERROR", e.toString());
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE) {
            Log.e("ERROR", "Unsupported Request");
            return;
        }

        LineLoginResult result = LineLoginApi.getLoginResultFromIntent(data);

        switch (result.getResponseCode()) {

            case SUCCESS:
                // Login successful

                Intent transitionIntent = new Intent(this, PostLoginActivity.class);
                //transitionIntent.putExtra("display_name", result.getLineProfile().getDisplayName());
                transitionIntent.putExtra("line_profile", result.getLineProfile());
                //transitionIntent.putExtra("line_credential", result.getLineCredential());
                startActivity(transitionIntent);
                break;

            case CANCEL:
                // Login canceled by user

                Log.e("ERROR", "LINE Login Canceled by user!!");
                break;

            default:
                Log.e("ERROR", "Login FAILED!");
                Log.e("ERROR", result.getErrorData().toString());
        }
    }


}
