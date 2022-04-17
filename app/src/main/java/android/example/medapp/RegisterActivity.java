package android.example.medapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText location;
    EditText name;
    EditText number;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        location = findViewById(R.id.locationEditTextReg);
        name = findViewById(R.id.NameEditText);
        number = findViewById(R.id.NumberEditText);
        register = findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() || number.getText().toString().isEmpty() || location.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "All fields mandatory", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(RegisterActivity.this, otpVerification.class);
                    intent.putExtra("location",location.getText().toString());
                    intent.putExtra("name",name.getText().toString());
                    intent.putExtra("number",number.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}