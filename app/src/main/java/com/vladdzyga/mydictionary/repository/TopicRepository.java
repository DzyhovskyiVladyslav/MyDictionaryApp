package com.vladdzyga.mydictionary.repository;

import android.content.Context;
import com.vladdzyga.mydictionary.database.DatabaseHelper;
import com.vladdzyga.mydictionary.database.TopicDao;
import com.vladdzyga.mydictionary.model.Topic;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:14
 */
public class TopicRepository {
    private TopicDao topicDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public TopicRepository(Context context) {
        DatabaseHelper db = DatabaseHelper.getDatabase(context);
        topicDao = db.topicDao();
    }

    public void insert(final Topic topic) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                topicDao.insert((topic));
            }
        });
    }

    public List<Topic> getTopicsForDictionary(int dictionaryId) {
        return topicDao.getTopicsForDictionary(dictionaryId);
    }
}
