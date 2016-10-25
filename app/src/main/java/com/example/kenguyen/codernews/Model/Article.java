package com.example.kenguyen.codernews.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KeNguyen on 21/10/2016.
 */

public class Article implements Serializable {
    String webUrl;
    String headLine;
    String thumbNail;

    public Article(JSONObject jsonObject){
        try{

            this.webUrl = jsonObject.getString("web_url");
            this.headLine = jsonObject.getJSONObject("headline").getString("main");
            JSONArray multimedia  = jsonObject.getJSONArray("multimedia");
            if(multimedia.length() >0){
                JSONObject multimediaJson = multimedia.getJSONObject(0);
                this.thumbNail ="http://www.nytimes.com/"+ multimediaJson.getString("url");
            }
            else{
                this.thumbNail = "";
            }
        }catch (JSONException e){
        e.printStackTrace();
        }
    }
    public  static ArrayList<Article> fromJsonArray(JSONArray array){
        ArrayList<Article> results = new ArrayList<Article>();
        for(int i=0;i<array.length();i++){
            try{
                results.add(new Article(array.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public String getHeadLine() {
        return headLine;
    }
}
