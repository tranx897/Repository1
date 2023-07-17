
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class MovieResponse {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("entries")
    @Expose
    private Integer entries;
    @SerializedName("results")
    @Expose
    private List<Result> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getEntries() {
        return entries;
    }

    public void setEntries(Integer entries) {
        this.entries = entries;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
