package android.example.medapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.HashMap;

public class AddMedicine extends AppCompatActivity {

    EditText medName;
    Button increase;
    Button decrease;
    Button add;
    TextView amount;
    private DocumentReference mdocref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        medName = findViewById(R.id.MedNameEditText);
        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);
        amount = findViewById(R.id.amountTextView);
        add = findViewById(R.id.add);


        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(amount.getText().toString());
                x=x+1;
                amount.setText(String.valueOf(x));
            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(amount.getText().toString());
                if(x>0){
                    x =x-1;
                }else{
                    Toast.makeText(AddMedicine.this, "cannot be less than zero", Toast.LENGTH_SHORT).show();
                }
                amount.setText(String.valueOf(x));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(medName.getText().toString().isEmpty()){
                    Toast.makeText(AddMedicine.this, "All fields necessary", Toast.LENGTH_SHORT).show();
                }else{
                    mdocref = FirebaseFirestore.getInstance().collection(getIntent().getStringExtra("location")).document(medName.getText().toString()).collection(getIntent()
                            .getStringExtra("name")).document("details");
                    HashMap<String,String> hm = new HashMap<>();
                    hm.put("Number",getIntent().getStringExtra("number"));
                    hm.put("quantity",amount.getText().toString());

                    mdocref.set(hm).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(AddMedicine.this, "Success", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddMedicine.this,"Failure",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
}