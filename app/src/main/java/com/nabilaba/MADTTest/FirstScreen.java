package com.nabilaba.MADTTest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FirstScreen extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        final EditText name = findViewById(R.id.name);  
        final EditText palindrome_text = findViewById(R.id.palindrome_text);
        
        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View p1) {                  
                    String GetEditText = palindrome_text.getText().toString();
                    String  reverse = "";
                    int length = GetEditText.trim().toLowerCase().length();
                    for ( int i = length - 1; i >= 0; i-- )
                        reverse = reverse + GetEditText.charAt(i);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(FirstScreen.this);
                    dialog.setTitle("Is Palindrom?");
                    if (GetEditText.trim().isEmpty()) {
                        dialog.setMessage("Input your text to check!");
                    } else if (GetEditText.replace(" ", "").toLowerCase().equals(reverse.replace(" ", "").toLowerCase())) {
                        dialog.setMessage("Yes, it's palindrom");
                    } else {
                        dialog.setMessage("No, it's not palindrom");
                    }
                    
                    dialog.setPositiveButton("OK", null);
                    dialog.show();
                }         
        });
        
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View p1) {
                    Intent secondScreen = new Intent(FirstScreen.this, SecondScreen.class);
                    secondScreen.putExtra("NAME", name.getText().toString().trim());
                    startActivity(secondScreen);
                }        
        });
        
        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        
    }
}
