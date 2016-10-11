package com.gabilheri.moviestmdb.data.models;

import java.util.List;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

public class CreditsResponse {

    private int id;
    private List<CastMember> cast;
    private List<CrewMember> crew;

    public CreditsResponse() {
    }

    public int getId() {
        return id;
    }

    public CreditsResponse setId(int id) {
        this.id = id;
        return this;
    }

    public List<CastMember> getCast() {
        return cast;
    }

    public CreditsResponse setCast(List<CastMember> cast) {
        this.cast = cast;
        return this;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public CreditsResponse setCrew(List<CrewMember> crew) {
        this.crew = crew;
        return this;
    }
}
