package com.pdamkotamadiun.aduin.model.token;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum implements Serializable
{

    @SerializedName("token")
    @Expose
    private String token;
    private final static long serialVersionUID = -3090052040686481739L;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("token", token).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(token).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Datum)) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return new EqualsBuilder().append(token, rhs.token).isEquals();
    }

}