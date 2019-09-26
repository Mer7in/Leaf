package com.example.leaf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaf.Model.Item;
import com.example.leaf.Model.Place;
import com.example.leaf.Model.Product;
import com.example.leaf.ProductCard;
import com.example.leaf.R;
import com.example.leaf.adapter.ItemAdapter;
import com.example.leaf.adapter.PlaceAdapter;
import com.example.leaf.adapter.ProductAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class LocationFragment extends Fragment {

    List<Place> places;
   // List<Item> items;
    PlaceAdapter placeAdapter;
   // ItemAdapter itemAdapter;
    RecyclerView recyclerView;
    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queryLocation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_location, container, false);
        recyclerView= view.findViewById(R.id.locationRv);
        placeAdapter=new PlaceAdapter(getContext(),places);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(placeAdapter);
        return view;
    }

    public void queryLocation()
    {

        ParseQuery<Place> query = new ParseQuery<Place>(Place.class);
        //query.whereEqualTo("type","Fruit");
        query.orderByAscending("city");
        places=new ArrayList<>();
        query.findInBackground(new FindCallback<Place>(){

            @Override
            public void done(List<Place> place, ParseException e) {
                if (e == null) {

                    places.clear();
                    places.addAll(place);
                    //Log.d("message",product.toString());
                    placeAdapter.notifyDataSetChanged();

                } else {
                    Log.e("message", "Error Loading Places" + e);
                }
            }
        });

    }

}
