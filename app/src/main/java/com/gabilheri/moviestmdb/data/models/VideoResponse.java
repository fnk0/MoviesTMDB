package com.gabilheri.moviestmdb.data.models;

import java.util.List;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

public class VideoResponse {

    private int id;
    private List<Video> results;

    public VideoResponse() {
    }

    public int getId() {
        return id;
    }

    public VideoResponse setId(int id) {
        this.id = id;
        return this;
    }

    public List<Video> getResults() {
        return results;
    }

    public VideoResponse setResults(List<Video> results) {
        this.results = results;
        return this;
    }
}
