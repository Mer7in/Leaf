package com.example.leaf.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaf.Model.Place;
import com.example.leaf.ProductCard;
import com.example.leaf.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    Context context;
    List<Place> places;


    public PlaceAdapter(Context context, List<Place> places)
    {
        this.context=context;
        this.places=places;
    }


    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.place_list,parent,false);
        ViewHolder vHolder=new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PlaceAdapter.ViewHolder holder, int position) {
        Place place=places.get(position);
        holder.bind(place);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewLocation;
        ImageButton cardListButton;
        View dividerLocation;
        RelativeLayout placeRv;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewLocation=itemView.findViewById(R.id.textViewLocation);
            cardListButton=itemView.findViewById(R.id.cardListButton);
            dividerLocation=itemView.findViewById(R.id.dividerLocation);
            placeRv=itemView.findViewById(R.id.placeRv);

        }

        public void bind(final Place place)
        {
            textViewLocation.setText(place.getCity());
            placeRv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, ProductCard.class);
                    i.putExtra("city",place.getCity());
                    i.putExtra("cityId",place.getObjectId());
                    context.startActivity(i);
                }
            });
        }

    }
}
