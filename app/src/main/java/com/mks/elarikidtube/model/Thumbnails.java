package com.mks.elarikidtube.model;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {
    @SerializedName("medium")
    private Medium medium;

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }


}