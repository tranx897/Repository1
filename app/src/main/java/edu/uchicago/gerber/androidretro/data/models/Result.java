
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Result {

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("primaryImage")
    @Expose
    private PrimaryImage primaryImage;
    @SerializedName("titleType")
    @Expose
    private TitleType titleType;
    @SerializedName("titleText")
    @Expose
    private TitleText titleText;
    @SerializedName("originalTitleText")
    @Expose
    private OriginalTitleText originalTitleText;
    @SerializedName("releaseYear")
    @Expose
    private ReleaseYear releaseYear;
    @SerializedName("releaseDate")
    @Expose
    private ReleaseDate releaseDate;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PrimaryImage getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(PrimaryImage primaryImage) {
        this.primaryImage = primaryImage;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public void setTitleType(TitleType titleType) {
        this.titleType = titleType;
    }

    public TitleText getTitleText() {
        return titleText;
    }

    public void setTitleText(TitleText titleText) {
        this.titleText = titleText;
    }

    public OriginalTitleText getOriginalTitleText() {
        return originalTitleText;
    }

    public void setOriginalTitleText(OriginalTitleText originalTitleText) {
        this.originalTitleText = originalTitleText;
    }

    public ReleaseYear getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(ReleaseYear releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}
