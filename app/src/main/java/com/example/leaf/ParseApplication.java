package com.example.leaf;

import android.app.Application;

import com.example.leaf.Model.Product;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Product.class);
        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("instagram-jeamik") // should correspond to APP_ID env variable
                .clientKey("codepath-instagram")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://instagram-jeamik.herokuapp.com/parse").build());
    }
}
