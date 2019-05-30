package com.mks.elarikidtube.model;

import com.google.gson.annotations.SerializedName;

public class Id {
    @SerializedName("videoId")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

}