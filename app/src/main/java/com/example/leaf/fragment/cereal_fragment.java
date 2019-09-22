package com.example.leaf.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaf.DetailActivity;
import com.example.leaf.Listener.ItemClickSupport;
import com.example.leaf.Model.Product;
import com.example.leaf.R;
import com.example.leaf.adapter.ProductAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;



public class cereal_fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Product> products;
    private ProductAdapter productAdapter;
    private final String TAG="cereal_fragment";

    public cereal_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        queryCereal();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_cereals, container, false);
        recyclerView= view.findViewById(R.id.cerealRecycleView);
        productAdapter=new ProductAdapter(getContext(),products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(productAdapter);
        this.configureOnClickRecyclerView();

        return view;
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_cereals)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Intent i=new Intent(getContext(), DetailActivity.class);
                        startActivity(i);
                    }
                });
    }

    public void queryCereal()
    {
        ParseQuery<Product> query = new ParseQuery<Product>(Product.class);
        query.whereEqualTo("type","Cereal");
        query.orderByAscending("name");
        products=new ArrayList<>();
        query.findInBackground(new FindCallback<Product>(){

            @Override
            public void done(List<Product> product, ParseException e) {
                if (e == null) {

                    products.clear();
                    products.addAll(product);
                    //Log.d("message",product.toString());
                    productAdapter.notifyDataSetChanged();

                } else {
                    Log.e("message", "Error Loading Products" + e);
                }
            }
        });

    }

}
