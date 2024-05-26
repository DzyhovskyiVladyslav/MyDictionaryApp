package com.vladdzyga.mydictionary.repository;

import android.content.Context;
import com.vladdzyga.mydictionary.database.DatabaseHelper;
import com.vladdzyga.mydictionary.database.DictionaryDao;
import com.vladdzyga.mydictionary.model.Dictionary;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 16:09
 */
public class DictionaryRepository {
    private DictionaryDao dictionaryDao;
    private Executor executor = Executors.newSingleThreadExecutor();

    public DictionaryRepository(Context context) {
        DatabaseHelper db = DatabaseHelper.getDatabase(context);
        dictionaryDao = db.dictionaryDao();
    }

    public void insert(final Dictionary dictionary) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dictionaryDao.insert((dictionary));
            }
        });
    }

    public List<Dictionary> getAllDictionaries() {
        return dictionaryDao.getAllDictionaries();
    }
}
