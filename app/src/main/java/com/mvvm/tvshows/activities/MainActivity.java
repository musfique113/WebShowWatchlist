package com.mvvm.tvshows.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> bc931a3d900fb7c75545756d032c4aa85d014540
import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.tvshows.R;
import com.mvvm.tvshows.adapters.TVShowsAdapter;
import com.mvvm.tvshows.databinding.ActivityMainBinding;
<<<<<<< HEAD
import com.mvvm.tvshows.listeners.TVShowsListener;
=======
>>>>>>> bc931a3d900fb7c75545756d032c4aa85d014540
import com.mvvm.tvshows.models.TVShow;
import com.mvvm.tvshows.viewmodels.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements TVShowsListener {
=======
public class MainActivity extends AppCompatActivity {
>>>>>>> bc931a3d900fb7c75545756d032c4aa85d014540
    private MostPopularTVShowsViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private List<TVShow> tvShows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;
    private int currentPage = 1;
    private int totalAvailablePages = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //link XML to java
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
        //  setContentView(R.layout.activity_main);
    }

    public void doInitialization() {
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tvShows, this);
        activityMainBinding.tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        activityMainBinding.tvShowsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!activityMainBinding.tvShowsRecyclerView.canScrollVertically(1)){
                    if (currentPage <= totalAvailablePages){
                        currentPage += 1;
                        getMostPopularTVShows();
                    }
                }
            }
        });
        getMostPopularTVShows();
    }

    private void getMostPopularTVShows() {
        //activityMainBinding.setIsLoading(true);
        toggleLoading();
        viewModel.getMostPopularTVShows(currentPage).observe(this, mostPopularTVShowsResponse -> {
            // activityMainBinding.setIsLoading(false);
            toggleLoading();
            if (mostPopularTVShowsResponse != null) {
                totalAvailablePages = mostPopularTVShowsResponse.getTotalPages();
                if (mostPopularTVShowsResponse.getTvShows() != null) {
                    int oldCount = tvShows.size();
                    tvShows.addAll(mostPopularTVShowsResponse.getTvShows());
                   // tvShowsAdapter.notifyDataSetChanged();
                    tvShowsAdapter.notifyItemRangeInserted(oldCount, tvShows.size());
                }

            }
            // Toast.makeText(getApplicationContext(), "Total Pages" + mostPopularTVShowsResponse.getTotalPages(), Toast.LENGTH_SHORT).show()
        });
    }

    private void toggleLoading() {
        if (currentPage == 1) {
            if (activityMainBinding.getIsLoading() != null && activityMainBinding.getIsLoading()) {
                activityMainBinding.setIsLoading(false);
            } else {
                activityMainBinding.setIsLoading(true);
            }
        } else {
            if (activityMainBinding.getIsLoadingMore() != null && activityMainBinding.getIsLoadingMore()) {
                activityMainBinding.setIsLoadingMore(false);
            } else {
                activityMainBinding.setIsLoadingMore(true);
            }
        }
    }

<<<<<<< HEAD
    @Override
    public void onTVShowClicked(TVShow tvShow) {
        Intent intent = new Intent(getApplicationContext(), TVShowDetailsActivity.class);
        intent.putExtra("id", tvShow.getId());
        intent.putExtra("name", tvShow.getName());
        intent.putExtra("startDate", tvShow.getStartDate());
        intent.putExtra("country", tvShow.getCountry());
        intent.putExtra("network", tvShow.getNetwork());
        intent.putExtra("status", tvShow.getStatus());
        startActivity(intent);
    }
=======
>>>>>>> bc931a3d900fb7c75545756d032c4aa85d014540
}