package com.vladdzyga.mydictionary.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vladdzyga.mydictionary.model.Word;
import com.vladdzyga.mydictionary.repository.WordRepository;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:49
 */
public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private MutableLiveData<List<Word>> wordsForTopic;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository  = new WordRepository(application);
        wordsForTopic  = new MutableLiveData<>();
    }

    private void loadWords(int topicId) {
        wordsForTopic.setValue(wordRepository.getWordsForTopic(topicId));
    }

    public LiveData<List<Word>> getWordsForTopic(int topicId) {
        loadWords(topicId);
        return wordsForTopic;
    }

    public void insert(Word word) {
        wordRepository.insert(word);
        loadWords(word.topicId);
    }
}
