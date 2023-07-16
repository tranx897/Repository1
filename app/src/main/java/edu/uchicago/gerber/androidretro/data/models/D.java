
package edu.uchicago.gerber.androidretro.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class D {

    @SerializedName("i")
    @Expose
    private I i;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("qid")
    @Expose
    private String qid;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("y")
    @Expose
    private Integer y;
    @SerializedName("yr")
    @Expose
    private String yr;

    public I getI() {
        return i;
    }

    public void setI(I i) {
        this.i = i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

}
