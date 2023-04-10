package com.example.kyle1minam2assign2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Migreene22Download extends Fragment {


    private ListView mListView;
    private ImageView mImageView;
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    public void onCreate(Bundle savedInstancesState) {




        super.onCreate(savedInstancesState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.greene_download, container, false);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstancesState){
        listView = view.findViewById(R.id.listview);
        items = new ArrayList<>();
        items.add("flower");
        items.add("car");
        items.add("planet");
        items.add("urban");

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}