package com.pdamkotamadiun.aduin.model.keluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Status implements Serializable
{

    @SerializedName("id_status")
    @Expose
    private int idStatus;
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = 1420500762712555557L;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idStatus", idStatus).append("status", status).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idStatus).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Status)) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(idStatus, rhs.idStatus).append(status, rhs.status).isEquals();
    }

}