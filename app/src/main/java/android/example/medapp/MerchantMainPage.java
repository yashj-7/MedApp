package android.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MerchantMainPage extends AppCompatActivity {

    Button add;
    Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_main_page);

        add = findViewById(R.id.addButton);
        get = findViewById(R.id.getButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MerchantMainPage.this,AddMedicine.class);
                intent.putExtra("location",getIntent().getStringExtra("location"));
                intent.putExtra("name",getIntent().getStringExtra("name"));
                intent.putExtra("number",getIntent().getStringExtra("number"));
                startActivity(intent);
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MerchantMainPage.this,GetMedicines.class);
                startActivity(i);
            }
        });
    }

}