package com.mks.elarikidtube.model;

import com.google.gson.annotations.SerializedName;

public class Medium {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}