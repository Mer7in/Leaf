package com.example.leaf.Model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

@ParseClassName("Market")
public class Market extends ParseObject {
    public static final String KEY_MARKET_ID="objectID";
    public static final String KEY_NAME="name";
    public static final String KEY_LOCATION="location";
    public static final String KEY_IMAGE="image";
    public static final String KEY_MARKETTYPE="marketType";
    public static final String KEY_RATE="rate";
    public static final String KEY_MAIN_LOCATION="placeId";

    public String getMarketId()
    {
        return getString(KEY_MARKET_ID);
    }

    public void setMarketId(String objectId)
    {
        put(KEY_MARKET_ID,objectId);
    }

    public String getName()
    {
        return getString(KEY_NAME);
    }

    public void setName(String name)
    {
        put(KEY_NAME,name);
    }

    public ParseGeoPoint getMarketLocation()
    {
        return getParseGeoPoint(KEY_LOCATION);
    }

    public void setMarketLocation(ParseGeoPoint location)
    {
        put(KEY_LOCATION,location);
    }

    public ParseFile getImage()
    {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile image)
    {
        put(KEY_IMAGE,image);
    }

    public String getMarkettype()
    {
        return getString(KEY_MARKETTYPE);
    }

    public void setMarkettype(String markettype)
    {
        put(KEY_MARKETTYPE,markettype);
    }

    public Number getRate()
    {
        return getNumber(KEY_RATE);
    }

    public void setRate(Number rate)
    {
        put(KEY_RATE,rate);
    }

    public String getMainLocation()
    {
        return getString(KEY_MAIN_LOCATION);
    }

    public void setMainLocation(String location)
    {
        put(KEY_LOCATION,location);
    }

}
