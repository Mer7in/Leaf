package com.example.leaf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaf.DetailActivity;
import com.example.leaf.Model.Product;
import com.example.leaf.R;
import com.example.leaf.adapter.ProductAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class fruit_fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Product> products;
    private ProductAdapter productAdapter;
    private final String TAG="fruit_fragment";
    public fruit_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_fruit, container, false);
        recyclerView= view.findViewById(R.id.fruitRecycleView);
        productAdapter=new ProductAdapter(getContext(),products);
        queryFruits();
        //Button button = (Button) view.findViewById(R.id.btnFruit);
        /*button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getContext(), DetailActivity.class);
                startActivity(i);
            }
        });*/
        return view;
    }

    private void queryFruits() {
        ParseQuery<Product> query = new ParseQuery<Product>(Product.class);
        query.whereEqualTo("type","Fruit");
        query.orderByAscending("name");
        query.findInBackground(new FindCallback<Product>(){

            @Override
            public void done(List<Product> product, ParseException e) {
                if (e == null) {
                    products.clear();
                    products.addAll(product);
                    productAdapter.notifyDataSetChanged(); // update adapter
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(productAdapter);
                } else {
                    Log.e("message", "Error Loading Messages" + e);
                }
            }
        });
    }

}
