package org.itstep.activityresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_FORM_ACTIVITY = 1;
    private FloatingActionButton fab;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(MainActivity.this, FormActivity.class), REQUEST_CODE_FORM_ACTIVITY);
        });
        linearLayout = findViewById(R.id.listLayut);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_FORM_ACTIVITY:
                //Toast.makeText(this, "FormActivity closed", Toast.LENGTH_SHORT).show();
                if(resultCode == RESULT_OK) {
                    if(data != null) {
                        String payload = data.getStringExtra(FormActivity.PAYLOAD);
                        addItem(payload);
                    }
                }
                break;
            default:
                break;
        }
    }

    private void addItem(String payload) {
        Toast.makeText(this, "Add " + payload, Toast.LENGTH_SHORT).show();
        LayoutInflater layoutInflater = getLayoutInflater();
        TextView textView = (TextView) layoutInflater.inflate(R.layout.list_item, linearLayout, false);
        textView.setText(payload);
        linearLayout.addView(textView);
    }
}