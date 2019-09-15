package com.example.leaf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class splashscreen extends AppCompatActivity {

    private LinearLayout =
    private ImageView polygon;
    private TextView splashtext1;
    private TextView splashtext2;

    private Handler mHandler;
    private Runnable mRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        splashlogo =findViewById(R.id.splashlogo);
        polygon=findViewById(R.id.polygon);
        splashtext1=findViewById(R.id.splashtext1);
        splashtext2=findViewById(R.id.splashtext2);

        mRunnable = new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), splashscreen.class));
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable,2000);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if(mHandler!=null && mRunnable !=null)
            mHandler.removeCallbacks(mRunnable);
    }
}
