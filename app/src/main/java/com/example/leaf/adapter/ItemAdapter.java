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

import com.example.leaf.Model.Item;
import com.example.leaf.ProductCard;
import com.example.leaf.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<Item> items;
    Context context;

    public ItemAdapter(Context context, List<Item> items)
    {
        this.context=context;
        this.items=items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.place_list, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item=items.get(position);
            holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
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

        public void bind(final Item item)
        {
            textViewLocation.setText(item.getPlaceId());
            placeRv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, ProductCard.class);
                    i.putExtra("objectId",item.getObjectId());
                    i.putExtra("cityId",item.getPlaceId());
                    i.putExtra("productId",item.getProductId());
                    i.putExtra("marketId",item.getMarketId());
                    context.startActivity(i);
                }
            });
        }
    }
}

