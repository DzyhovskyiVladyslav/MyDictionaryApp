package com.vladdzyga.mydictionary.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.vladdzyga.mydictionary.R;
import com.vladdzyga.mydictionary.model.Dictionary;
import com.vladdzyga.mydictionary.viewmodel.DictionaryViewModel;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 18:07
 */
public class DictionaryActivity extends AppCompatActivity {

    private DictionaryViewModel dictionaryViewModel;
    private ArrayAdapter<Dictionary> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        final EditText editDictionaryName = findViewById(R.id.edit_dictionary_name);
        final EditText editLanguageFrom = findViewById(R.id.edit_language_from);
        final EditText editLanguageTo = findViewById(R.id.edit_language_to);
        Button btnAddDictionary = findViewById(R.id.btn_add_dictionary);
        ListView listDictionaries = findViewById(R.id.list_dictionaries);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listDictionaries.setAdapter(adapter);

        dictionaryViewModel = new ViewModelProvider(this).get(DictionaryViewModel.class);
        dictionaryViewModel.getAllDictionaries().observe(this, new Observer<List<Dictionary>>() {
            @Override
            public void onChanged(List<Dictionary> dictionaries) {
                adapter.clear();
                adapter.addAll(dictionaries);
            }
        });

        btnAddDictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editDictionaryName.getText().toString();
                String languageFrom = editLanguageFrom.getText().toString();
                String languageTo = editLanguageTo.getText().toString();
                Dictionary dictionary = new Dictionary();
                dictionary.name = name;
                dictionary.languageFrom = languageFrom;
                dictionary.languageTo = languageTo;
                dictionaryViewModel.insert(dictionary);
            }
        });
    }
}
