package android.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class otpVerification extends AppCompatActivity {

    EditText otp;
    Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        otp = findViewById(R.id.otpEditText);
        verify = findViewById(R.id.verify);
        String location = getIntent().getStringExtra("location");
        String name = getIntent().getStringExtra("name");
        String number = getIntent().getStringExtra("number");

        Log.v("location",location);
        Log.v("name",name);
        Log.d("number",number);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(otpVerification.this,MerchantMainPage.class);
                intent.putExtra("location",location);
                intent.putExtra("name",name);
                intent.putExtra("number",number);
                startActivity(intent);
            }
        });

    }
}