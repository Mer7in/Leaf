package com.example.leaf.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.leaf.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cereals_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cereals_fragment extends Fragment {

    public cereals_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cereals, container, false);
    }

}
