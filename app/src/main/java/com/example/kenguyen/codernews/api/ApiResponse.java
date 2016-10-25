package com.example.kenguyen.codernews.api;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by KeNguyen on 25/10/2016.
 */

public class ApiResponse {
    @SerializedName("response")
    private JSONObject response;

    @SerializedName("status")
    private String status;
    public JSONObject getResponse(){
        if(response==null) {
            return new JSONObject();
        }
        return response;
    }
    public String getStatus(){return status;}
}
