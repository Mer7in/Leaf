package com.example.leaf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import com.example.leaf.Model.Product;
import com.example.leaf.fragment.CheafFragment;
import com.example.leaf.fragment.InfoFragment;
import com.example.leaf.fragment.LocationFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private Product product;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView toolbar_title;
    private int[] tabIcons = {
            R.drawable.ic_place_white_56dp,
            R.drawable.ic_info_black_24dp,
            R.drawable.cheaf
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        final String name=getIntent().getStringExtra("name");
        final String image=getIntent().getStringExtra("url");

        toolbar = findViewById(R.id.toolbar);
        toolbar_title=findViewById(R.id.toolbar_title);

        DownloadImageTask downloadImageTask= (DownloadImageTask) new DownloadImageTask(toolbar).execute(image);
        toolbar_title.setText(name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });



        viewPager= findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        DetailActivity.ViewPagerAdapter adapter = new DetailActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LocationFragment(), "Location");
        adapter.addFragment(new InfoFragment(), "Info");
        adapter.addFragment(new CheafFragment(), "Recipes");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        Toolbar toolbar;
        public DownloadImageTask(Toolbar toolbar) {
            this.toolbar = toolbar;
        }

        protected Bitmap doInBackground(String... url) {
            String urldisplay = url[0];
            Bitmap bmp = null;
            try {
                @SuppressWarnings("deprecation") InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            Drawable drawable=new BitmapDrawable(result);
            toolbar.setBackground(drawable);
        }
    }
}

