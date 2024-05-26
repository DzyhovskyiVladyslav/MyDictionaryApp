package com.vladdzyga.mydictionary.repository;

import android.content.Context;
import com.vladdzyga.mydictionary.database.DatabaseHelper;
import com.vladdzyga.mydictionary.database.WordDao;
import com.vladdzyga.mydictionary.model.Word;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:17
 */
public class WordRepository {
    private WordDao wordDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public WordRepository(Context context) {
        DatabaseHelper db = DatabaseHelper.getDatabase(context);
        wordDao = db.wordDao();
    }

    public void insert(final Word word) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                wordDao.insert((word));
            }
        });
    }

    public List<Word> getWordsForTopic(int topicId) {
        return wordDao.getWordsForTopic(topicId);
    }
}
