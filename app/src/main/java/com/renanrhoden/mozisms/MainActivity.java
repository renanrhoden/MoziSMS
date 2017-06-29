package com.renanrhoden.mozisms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, 0);
            }
        }

    public void sendSMS(View view){
        EditText message = (EditText) findViewById(R.id.messageId);
        String text =  message.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+5551992679152", null, text, null, null);

        Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        message.setText("");
    }
}
