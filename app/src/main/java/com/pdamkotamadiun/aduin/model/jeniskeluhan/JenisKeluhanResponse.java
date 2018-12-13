package com.pdamkotamadiun.aduin.model.jeniskeluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class JenisKeluhanResponse implements Serializable
{

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<JenisKeluhan> data = null;
    private final static long serialVersionUID = 1241283787822351056L;

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

    public List<JenisKeluhan> getData() {
        return data;
    }

    public void setData(List<JenisKeluhan> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("error", error).append("message", message).append("data", data).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(error).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JenisKeluhanResponse)) {
            return false;
        }
        JenisKeluhanResponse rhs = ((JenisKeluhanResponse) other);
        return new EqualsBuilder().append(message, rhs.message).append(error, rhs.error).append(data, rhs.data).isEquals();
    }

}