package com.gabilheri.moviestmdb.ui.movies;

import android.content.Context;

import com.gabilheri.moviestmdb.data.models.Movie;
import com.gabilheri.moviestmdb.ui.base.BindableCardView;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/8/16.
 */
public class MovieCardView extends BindableCardView<Movie> {

    public MovieCardView(Context context) {
        super(context);
    }

    @Override
    protected void bind(Movie data) {

    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }
}
