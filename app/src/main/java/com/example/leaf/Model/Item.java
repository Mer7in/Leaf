package com.example.leaf.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Item")
public class Item extends ParseObject {
    public static final String KEY_ID="objectId";
    public static final String KEY_MARKET_ID="marketId";
    public static final String  KEY_PRODUCT_ID="productId";

    public String getObjectId()
    {
        return getString(KEY_ID);
    }

    public void setObjectId(String objectId)
    {
        put(KEY_ID,objectId);
    }

    public String getMarketId()
    {
        return getString(KEY_MARKET_ID);
    }

    public void setMarketId(String marketId)
    {
        put(KEY_MARKET_ID,marketId);
    }

    public String getProductId()
    {
        return getString(KEY_PRODUCT_ID);
    }

    public void setProductId(String productId)
    {
        put(KEY_MARKET_ID,productId);
    }
}
