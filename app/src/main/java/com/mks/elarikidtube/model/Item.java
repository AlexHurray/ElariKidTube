package com.mks.elarikidtube.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    private Id id;
    @SerializedName("snippet")
    private Snippet snippet;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

}