package com.gabilheri.moviestmdb.ui.details;

import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;

import com.gabilheri.moviestmdb.App;
import com.gabilheri.moviestmdb.Config;
import com.gabilheri.moviestmdb.data.Api.TheMovieDbAPI;
import com.gabilheri.moviestmdb.data.models.Movie;
import com.gabilheri.moviestmdb.data.models.MovieDetails;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/11/16.
 */
public class MovieDetailsFragment extends DetailsFragment {

    // Injects the API using Dagger
    @Inject
    TheMovieDbAPI mDbAPI;

    private Movie movie;
    private MovieDetails movieDetails;
    private ArrayObjectAdapter mAdapter;

    /**
     * Creates a new instance of a MovieDetailsFragment
     * @param movie
     *      The movie to be used by this fragment
     * @return
     *      A newly created instance of MovieDetailsFragment
     */
    public static MovieDetailsFragment newInstance(Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(Movie.class.getSimpleName(), movie);
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injects this into the main component. Necessary for Dagger 2
        App.instance().appComponent().inject(this);
        if (getArguments() == null || !getArguments().containsKey(Movie.class.getSimpleName())) {
            throw new RuntimeException("An movie is necessary for MovieDetailsFragment");
        }

        // Retrieves the movie from the arguments
        movie = getArguments().getParcelable(Movie.class.getSimpleName());
        setUpAdapter();
        setUpDetailsOverviewRow();
    }

    /**
     * Sets up the adapter for this Fragment
     */
    private void setUpAdapter() {

    }

    /**
     * Sets up the details overview rows
     */
    private void setUpDetailsOverviewRow() {

    }

    /**
     * Fetches the movie details for a specific Movie.
     */
    private void fetchMovieDetails() {
        mDbAPI.getMovieDetails(movie.getId(), Config.API_KEY_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindMovieDetails, e -> {
                    Timber.e(e, "Error fetching data: %s", e.getMessage());
                });
    }

    private void bindMovieDetails(MovieDetails movieDetails) {
        this.movieDetails = movieDetails;
    }

}
