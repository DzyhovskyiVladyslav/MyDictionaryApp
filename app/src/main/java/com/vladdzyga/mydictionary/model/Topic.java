package com.vladdzyga.mydictionary.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:13
 */
@Entity(foreignKeys = @ForeignKey(entity = Dictionary.class, parentColumns = "id", childColumns = "dictionaryId"))
public class Topic {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int dictionaryId;
    public String name;
}
