package com.vladdzyga.mydictionary.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.vladdzyga.mydictionary.model.Word;
import java.util.List;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:27
 */
@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Query("SELECT * FROM Word WHERE topicId = :topicId")
    List<Word> getWordsForTopic(int topicId);
}