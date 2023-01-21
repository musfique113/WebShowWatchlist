package com.mvvm.tvshows.responses;

import com.google.gson.annotations.SerializedName;
import com.mvvm.tvshows.models.TVShowDetails;

public class TVShowDetailsResponse {
    @SerializedName("tvShow")
    private TVShowDetails tvShowDetails;

    public TVShowDetails getTvShowDetails() {
        return tvShowDetails;
    }
}
