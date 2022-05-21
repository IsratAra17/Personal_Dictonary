package com.example.personal_dictonary.navdrawer.ui.GetData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personal_dictonary.Adapter.WordAdapter;
import com.example.personal_dictonary.ModelClass.ModelDictionary;
import com.example.personal_dictonary.Repository.WordRepository;
import com.example.personal_dictonary.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    EditText word, meaning;
    WordRepository repository;
    RecyclerView recyclerView;
    WordAdapter wordAdapter;
    ArrayList<ModelDictionary> wordList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        repository = new WordRepository(getContext());

        // word = findViewById(R.id.et_word);
        //meaning= findViewById(R.id.et_meaning);
        //recyclerView = findViewById(R.id.recyclerViewWord);

        binding.recyclerViewWord.setLayoutManager(new LinearLayoutManager(getContext()));

        wordAdapter = new WordAdapter(wordList, getContext());
        recyclerView.setAdapter(wordAdapter);


        getData();


     /*   final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void getData() {
        repository.getAllData().observe(getViewLifecycleOwner(), new Observer<List<ModelDictionary>>() {
            @Override
            public void onChanged(List<ModelDictionary> modelDictionaries) {
                wordList.clear();
                wordList.addAll(modelDictionaries);
                wordAdapter.notifyDataSetChanged();
            }
        });


    }
}