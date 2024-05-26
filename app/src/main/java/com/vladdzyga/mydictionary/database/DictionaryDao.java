package com.vladdzyga.mydictionary.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.vladdzyga.mydictionary.model.Dictionary;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:19
 */
@Dao
public interface DictionaryDao {
    @Insert
    void insert(Dictionary dictionary);

    @Query("SELECT * FROM Dictionary")
    List<Dictionary> getAllDictionaries();
}
