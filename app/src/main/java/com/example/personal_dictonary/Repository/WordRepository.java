package com.example.personal_dictonary.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.personal_dictonary.ModelClass.ModelDictionary;
import com.example.personal_dictonary.Room.MyRoomDatabase;
import com.example.personal_dictonary.Room.RoomDao;

import java.util.List;

public class WordRepository {

    private RoomDao roomDao;
    private MyRoomDatabase roomDatabase;
    private LiveData<List<ModelDictionary>>allData;
    private Context context;

    public WordRepository(Context context) {

        this.context = context;
        roomDatabase=MyRoomDatabase.getInstance(context);
        roomDao=roomDatabase.roomDao();
        allData=roomDao.getAllData();
    }



    public LiveData<List<ModelDictionary>> getAllData(){
        return  this.allData;
    }

    public void insertSingleData(ModelDictionary dictionary) {
        new InsertData(roomDao).execute(dictionary);
    }


    private class InsertData extends AsyncTask<ModelDictionary,Void,Void> {


        RoomDao roomDao;
        public InsertData(RoomDao roomDao) {
            this.roomDao = roomDao;
        }




        @Override
        protected Void doInBackground(ModelDictionary... modelDictionaries) {

            roomDao.insertSingleData(modelDictionaries[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Data insert Successful", Toast.LENGTH_SHORT).show();
        }


    }
}
