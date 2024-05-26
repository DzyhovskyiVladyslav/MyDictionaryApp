package com.vladdzyga.mydictionary.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.vladdzyga.mydictionary.model.Topic;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:25
 */
@Dao
public interface TopicDao {
    @Insert
    void insert(Topic topic);

    @Query("SELECT * FROM Topic WHERE dictionaryId = :dictionaryId")
    List<Topic> getTopicsForDictionary(int dictionaryId);
}
