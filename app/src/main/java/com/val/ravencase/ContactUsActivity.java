package com.val.ravencase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        TextView textTitle = (TextView)findViewById(R.id.textTitle);
        textTitle.setText("Contact Center");

        Button buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmail(view);
            }
        });

        Button buttonWhatsapp = (Button) findViewById(R.id.buttonWhatsapp);
        buttonWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsapp(view);
            }
        });

        Button buttonCall = (Button) findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCall(view);
            }
        });
    }

    public void openEmail(View v) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"arron2501@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact Center - Raven Case");
        intent.putExtra(Intent.EXTRA_TEXT, "I need help about something...");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWhatsapp(View view) {
        String url = "https://wa.me/+6285777709900?text=I%20need%20help%20about%20something...";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void openCall(View view) {
        String no = "085777709900";
        Intent tlp = new Intent(Intent.ACTION_DIAL);
        tlp.setData(Uri.fromParts("tel", no, null));
        startActivity(tlp);
    }
}