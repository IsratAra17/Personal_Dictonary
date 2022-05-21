package com.example.personal_dictonary.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.personal_dictonary.ModelClass.ModelDictionary;

@Database(entities = ModelDictionary.class,version = 1,exportSchema = false)

public abstract class MyRoomDatabase extends RoomDatabase{

        private static MyRoomDatabase roomDataBase = null;

        public abstract RoomDao roomDao();

        public static synchronized MyRoomDatabase getInstance(Context context)
        {
            if (roomDataBase==null)
            {
                roomDataBase = Room.databaseBuilder(context, MyRoomDatabase.class,"wordDb")
                        .fallbackToDestructiveMigration()
                        .build();
            }

            return roomDataBase;
        }

    }


