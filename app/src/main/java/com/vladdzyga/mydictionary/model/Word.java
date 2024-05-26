package com.vladdzyga.mydictionary.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:13
 */
@Entity(foreignKeys = @ForeignKey(entity = Topic.class, parentColumns = "id", childColumns = "topicId"))
public class Word {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int topicId;
    public String word;
    public String translation;
}
