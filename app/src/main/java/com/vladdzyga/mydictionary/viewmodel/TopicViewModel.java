package com.vladdzyga.mydictionary.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vladdzyga.mydictionary.model.Topic;
import com.vladdzyga.mydictionary.repository.TopicRepository;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:43
 */
public class TopicViewModel extends AndroidViewModel {
    private TopicRepository topicRepository;
    private MutableLiveData<List<Topic>> topicsForDictionary;

    public TopicViewModel(@NonNull Application application) {
        super(application);
        topicRepository  = new TopicRepository(application);
        topicsForDictionary  = new MutableLiveData<>();
    }

    private void loadTopics(int dictionaryId) {
        topicsForDictionary.setValue(topicRepository.getTopicsForDictionary(dictionaryId));
    }

    public LiveData<List<Topic>> getTopicsForDictionary(int dictionaryId) {
        loadTopics(dictionaryId);
        return topicsForDictionary;
    }

    public void insert(Topic topic) {
        topicRepository.insert(topic);
        loadTopics(topic.dictionaryId);
    }
}
