
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class TitleType {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("isSeries")
    @Expose
    private Boolean isSeries;
    @SerializedName("isEpisode")
    @Expose
    private Boolean isEpisode;
    @SerializedName("__typename")
    @Expose
    private String __typename;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsSeries() {
        return isSeries;
    }

    public void setIsSeries(Boolean isSeries) {
        this.isSeries = isSeries;
    }

    public Boolean getIsEpisode() {
        return isEpisode;
    }

    public void setIsEpisode(Boolean isEpisode) {
        this.isEpisode = isEpisode;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

}
