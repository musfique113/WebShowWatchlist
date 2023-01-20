package com.mvvm.tvshows.activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.databinding.DataBindingUtil;
        import androidx.lifecycle.ViewModel;
        import androidx.lifecycle.ViewModelProvider;

        import android.os.Bundle;
        import android.widget.Toast;

        import com.mvvm.tvshows.R;
        import com.mvvm.tvshows.adapters.TVShowsAdapter;
        import com.mvvm.tvshows.databinding.ActivityMainBinding;
        import com.mvvm.tvshows.models.TVShow;
        import com.mvvm.tvshows.viewmodels.MostPopularTVShowsViewModel;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MostPopularTVShowsViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private List<TVShow> tvShows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //link XML to java
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
      //  setContentView(R.layout.activity_main);


    }

    public void doInitialization(){
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tvShows);
        activityMainBinding.tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        getMostPopularTVShows();
    }
    private void getMostPopularTVShows() {
        activityMainBinding.setIsLoading(true);
        viewModel.getMostPopularTVShows(0).observe(this, mostPopularTVShowsResponse ->{
            activityMainBinding.setIsLoading(false);
            if (mostPopularTVShowsResponse != null) {
                if (mostPopularTVShowsResponse.getTvShows() != null){
                    tvShows.addAll(mostPopularTVShowsResponse.getTvShows());
                    tvShowsAdapter.notifyDataSetChanged();
                }

            }
            // Toast.makeText(getApplicationContext(), "Total Pages" + mostPopularTVShowsResponse.getTotalPages(), Toast.LENGTH_SHORT).show()
        });
    }
}