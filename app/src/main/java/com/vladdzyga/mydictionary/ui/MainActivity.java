package com.vladdzyga.mydictionary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.vladdzyga.mydictionary.R;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 18:00
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_manage_dictionaries).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DictionaryActivity.class));
            }
        });
    }
}
