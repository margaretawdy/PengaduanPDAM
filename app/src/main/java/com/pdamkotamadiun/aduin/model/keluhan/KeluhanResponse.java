package com.pdamkotamadiun.aduin.model.keluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class KeluhanResponse implements Serializable
{

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("keluhanList")
    @Expose
    private KeluhanList keluhanList;
    private final static long serialVersionUID = 2798159230708521111L;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public KeluhanList getKeluhanList() {
        return keluhanList;
    }

    public void setKeluhanList(KeluhanList keluhanList) {
        this.keluhanList = keluhanList;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("error", error).append("message", message).append("keluhanList", keluhanList).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(error).append(keluhanList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof KeluhanResponse)) {
            return false;
        }
        KeluhanResponse rhs = ((KeluhanResponse) other);
        return new EqualsBuilder().append(message, rhs.message).append(error, rhs.error).append(keluhanList, rhs.keluhanList).isEquals();
    }

}