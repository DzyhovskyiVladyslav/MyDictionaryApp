package com.vladdzyga.mydictionary.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.vladdzyga.mydictionary.model.Dictionary;
import com.vladdzyga.mydictionary.model.Topic;
import com.vladdzyga.mydictionary.model.Word;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:12
 */
@Database(entities = {Dictionary.class, Topic.class, Word.class}, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static volatile DatabaseHelper INSTANCE;
    public abstract DictionaryDao dictionaryDao();
    public abstract TopicDao topicDao();
    public abstract WordDao wordDao();

    public static DatabaseHelper getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseHelper.class, "my_dictionary_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
