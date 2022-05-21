package com.example.personal_dictonary.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.personal_dictonary.ModelClass.ModelDictionary;

import java.util.List;

@Dao
public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleData(ModelDictionary dictionary);

    @Query("SELECT *FROM dictionary")
    LiveData<List<ModelDictionary>>getAllData();
}
