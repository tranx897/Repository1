
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class OriginalTitleText {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("__typename")
    @Expose
    private String __typename;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

}
