package com.example.leaf.Model;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

@ParseClassName("Place")
public class Place extends ParseObject {

    public static final String KEY_ID="objectId";
    public static final String KEY_CITY="city";
    public static final String KEY_LOCATION="location";

    public String getObjectId()
    {
        return getString(KEY_ID);
    }

    public void setObjectId(String objectId)
    {
        put(KEY_ID,objectId);
    }

    public String getCity()
    {
        return getString(KEY_CITY);
    }

    public void setCity(String city)
    {
        put(KEY_CITY,city);
    }

    public ParseGeoPoint getLocation()
    {
        return getParseGeoPoint(KEY_LOCATION);
    }

    public void setLocation(ParseGeoPoint location)
    {
        put(KEY_LOCATION,location);
    }

}
