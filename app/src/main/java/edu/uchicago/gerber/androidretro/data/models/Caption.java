
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Caption {

    @SerializedName("plainText")
    @Expose
    private String plainText;
    @SerializedName("__typename")
    @Expose
    private String __typename;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

}
