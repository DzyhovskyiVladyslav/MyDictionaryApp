package com.vladdzyga.mydictionary.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author VladyslavDzyhovskyi
 * Created 26-May-24 at 15:13
 */
@Entity
public class Dictionary {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String languageFrom;
    public String languageTo;
}