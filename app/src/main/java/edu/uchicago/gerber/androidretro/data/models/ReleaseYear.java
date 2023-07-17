
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ReleaseYear {

    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("endYear")
    @Expose
    private Object endYear;
    @SerializedName("__typename")
    @Expose
    private String __typename;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Object getEndYear() {
        return endYear;
    }

    public void setEndYear(Object endYear) {
        this.endYear = endYear;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

}
