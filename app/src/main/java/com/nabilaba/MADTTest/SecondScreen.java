package com.nabilaba.MADTTest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class SecondScreen extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar); 
        
        setSupportActionBar(toolbar);       
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        centerToolbarTitle(toolbar);
        
        TextView name = findViewById(R.id.name);
        if (!getIntent().getStringExtra("NAME").isEmpty()) {
            name.setText(getIntent().getStringExtra("NAME"));
        }

        Button choose = findViewById(R.id.choose);
        choose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View p1) {
                    Intent thirdScreen = new Intent(getApplicationContext(), ThirdScreen.class);
                    startActivityForResult(thirdScreen, REQUEST_CODE);
                }
            });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {            
            if (resultCode == RESULT_OK) {
                if (data.hasExtra("FULL_NAME")) {
                    TextView user = findViewById(R.id.user);
                    user.setText(data.getStringExtra("FULL_NAME"));
                }
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    
    static void centerToolbarTitle(@NonNull final Toolbar toolbar) {
        final CharSequence title = toolbar.getTitle();
        final ArrayList<View> outViews = new ArrayList<>(1);
        toolbar.findViewsWithText(outViews, title, View.FIND_VIEWS_WITH_TEXT);
        if (!outViews.isEmpty()) {
            final TextView titleView = (TextView) outViews.get(0);
            titleView.setGravity(Gravity.CENTER);
            final Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) titleView.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            toolbar.requestLayout();
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dev:
                Intent dev = new Intent();
                dev.setAction(Intent.ACTION_VIEW);
                dev.addCategory(Intent.CATEGORY_BROWSABLE);
                dev.setData(Uri.parse("https://api.whatsapp.com/send?phone=+6283146542084"));
                startActivity(dev);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
