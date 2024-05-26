package com.vladdzyga.mydictionary.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.vladdzyga.mydictionary.R;
import com.vladdzyga.mydictionary.model.Word;
import com.vladdzyga.mydictionary.viewmodel.WordViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 18:18
 */
public class WordActivity extends AppCompatActivity {

    private WordViewModel wordViewModel;
    private ArrayAdapter<Word> adapter;
    private List<Word> wordList = new ArrayList<>();
    private int topicId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        final EditText editWord = findViewById(R.id.edit_word);
        final EditText editTranslation = findViewById(R.id.edit_translation);
        Button btnAddWord = findViewById(R.id.btn_add_word);
        ListView listWords = findViewById(R.id.list_words);
        SearchView searchView = findViewById(R.id.search_view);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wordList);
        listWords.setAdapter(adapter);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        wordViewModel.getWordsForTopic(topicId).observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.clear();
                adapter.addAll(words);
                adapter.notifyDataSetChanged();
            }
        });

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wordText = editWord.getText().toString();
                String translation = editTranslation.getText().toString();
                Word word = new Word();
                word.word = wordText;
                word.translation = translation;
                word.topicId = topicId;
                wordViewModel.insert(word);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }

    private void filter(String text) {
        List<Word> filteredList = new ArrayList<>();
        for (Word word : wordList) {
            if (word.word.toLowerCase().contains(text.toLowerCase()) ||
                    word.translation.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(word);
            }
        }
        adapter.clear();
        adapter.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }
}
