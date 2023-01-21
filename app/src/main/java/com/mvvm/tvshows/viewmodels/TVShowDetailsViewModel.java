package com.mvvm.tvshows.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvm.tvshows.repositories.TVShowDetailsRepository;
import com.mvvm.tvshows.responses.TVShowDetailsResponse;

public class TVShowDetailsViewModel extends ViewModel {

    private TVShowDetailsRepository tvShowDetailsRepository;
    public TVShowDetailsViewModel(){
        tvShowDetailsRepository = new TVShowDetailsRepository();
    }
    public LiveData<TVShowDetailsResponse> getTVShowDetails(String tvShowId){
        return tvShowDetailsRepository.getTVShowDetails(tvShowId);
    }
}
