package org.itstep.activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    public static final String PAYLOAD = "payload";
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        mEditText = findViewById(R.id.editText);
    }

    public void closeForm(View view) {
        String text = mEditText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(PAYLOAD, text);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this, "Click Save or Cancel to return", Toast.LENGTH_SHORT).show();
    }
}