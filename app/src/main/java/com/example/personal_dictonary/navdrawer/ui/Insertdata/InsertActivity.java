package com.example.personal_dictonary.navdrawer.ui.Insertdata;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personal_dictonary.Adapter.WordAdapter;
import com.example.personal_dictonary.ModelClass.ModelDictionary;
import com.example.personal_dictonary.Repository.WordRepository;
import com.example.personal_dictonary.databinding.ActivityInsertBinding;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {
    WordRepository repository;
    RecyclerView recyclerView;
    WordAdapter wordAdapter;
    ArrayList<ModelDictionary> wordtList = new ArrayList<>();

    private ActivityInsertBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_insert);

        binding=ActivityInsertBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        wordAdapter=new WordAdapter(wordtList,this);
        binding.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                word=binding.etWord.getText().toString();
                mean=binding.etMeaning.getText().toString();
                repository.insertSingleData(new ModelDictionary(word,mean));

            }
        });
    }
}