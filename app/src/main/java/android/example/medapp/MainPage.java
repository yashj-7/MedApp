package android.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainPage extends AppCompatActivity {

    EditText medicineName ;
    EditText location;
    Button search;
    Button login_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        medicineName = findViewById(R.id.medicineEditText);
        location = findViewById(R.id.locationEditText);
        search = findViewById(R.id.search);
        login_reg = findViewById(R.id.login_reg);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainPage.this,medicineResults.class);
                startActivity(intent);
            }
        });
        login_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}