package com.example.leaf.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.leaf.Model.Product;
import com.example.leaf.R;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products)
    {
        this.context=context;
        this.products=products;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        ViewHolder vHolder=new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, int position) {
            holder.description.setText(products.get(position).getName());
            ParseFile image = products.get(position).getImage();
        image.getDataInBackground(new GetDataCallback() {
            public void done(byte[] data, ParseException e) {
                if (e == null) {
                    // Decode the Byte[] into bitmap
                    Bitmap bmp = BitmapFactory.decodeByteArray(data, 0,data.length);
                    // Set the Bitmap into the imageView
                    holder.icon.setImageBitmap(bmp);
                } else {
                    Log.d("test", "There was a problem downloading the data.");
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public static  class ViewHolder  extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon= itemView.findViewById(R.id.icon);
            description= itemView.findViewById(R.id.description);
        }
    }
    //List<Product> product;
}
