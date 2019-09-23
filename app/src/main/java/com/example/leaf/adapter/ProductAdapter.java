package com.example.leaf.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.leaf.DetailActivity;
import com.example.leaf.Model.Product;
import com.example.leaf.R;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    Context context;
    List<Product> products;

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
        Product product=products.get(position);
        holder.bind(product);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }


    public  class ViewHolder  extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView description;
        private RelativeLayout productRv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon= itemView.findViewById(R.id.icon);
            description= itemView.findViewById(R.id.description);
            productRv=itemView.findViewById(R.id.productRv);
        }

        public void bind(final Product product) {
            description.setText(product.getName());
            ParseFile image = product.getImage();
            image.getDataInBackground(new GetDataCallback() {
                public void done(byte[] data, ParseException e) {
                    if (e == null) {
                        // Decode the Byte[] into bitmap
                        Bitmap bmp = BitmapFactory.decodeByteArray(data, 0,data.length);
                        // Set the Bitmap into the imageView
                        icon.setImageBitmap(bmp);
                        Log.d("test","Image loaded");
                    } else {
                        Log.d("test", "There was a problem downloading the data.");
                    }
                }
            });
        productRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(context, DetailActivity.class);
               i.putExtra("objectId",product.getObjectId());
               i.putExtra("name",product.getName());
               i.putExtra("type",product.getType());
               ParseFile file=product.getParseFile("image");
               i.putExtra("url",file.getUrl());
               context.startActivity(i);
            }
        });
        }
    }


}
