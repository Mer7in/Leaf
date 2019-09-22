package com.example.leaf.Model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
@ParseClassName("Product")
public class Product extends ParseObject {

    public static final String KEY_ID="objectId";
    public static final String KEY_NAME="name";
    public static final String KEY_IMAGE="image";
    public static final String KEY_TYPE="type";

    public String getObjectId(){return getString (KEY_ID);}

    public void setObjectId(String objectId){put(KEY_ID,objectId);}

    public String getName(){
        return getString(KEY_NAME);
    }

    public void setName(String name)
    {
        put(KEY_NAME, name);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE,parseFile);
    }

    public String getType(){
        return getString(KEY_TYPE);
    }

    public void setType(String type)
    {
        put(KEY_TYPE,type);
    }
}
