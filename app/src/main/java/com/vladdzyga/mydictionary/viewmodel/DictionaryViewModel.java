package com.vladdzyga.mydictionary.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vladdzyga.mydictionary.model.Dictionary;
import com.vladdzyga.mydictionary.repository.DictionaryRepository;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:37
 */
public class DictionaryViewModel extends AndroidViewModel {
    private DictionaryRepository dictionaryRepository;
    private MutableLiveData<List<Dictionary>> allDictionaries;

    public DictionaryViewModel(@NonNull Application application) {
        super(application);
        dictionaryRepository = new DictionaryRepository(application);
        allDictionaries = new MutableLiveData<>();
        loadDictionaries();
    }

    private void loadDictionaries() {
        allDictionaries.setValue(dictionaryRepository.getAllDictionaries());
    }

    public LiveData<List<Dictionary>> getAllDictionaries() {
        return allDictionaries;
    }

    public void insert(Dictionary dictionary) {
        dictionaryRepository.insert(dictionary);
        loadDictionaries();
    }
}
