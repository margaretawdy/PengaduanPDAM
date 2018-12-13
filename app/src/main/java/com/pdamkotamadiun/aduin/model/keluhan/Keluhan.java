package com.pdamkotamadiun.aduin.model.keluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pdamkotamadiun.aduin.model.jeniskeluhan.JenisKeluhan;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Keluhan implements Serializable, SortedListAdapter.ViewModel
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_kelurahan")
    @Expose
    private int idKelurahan;
    @SerializedName("id_pengguna")
    @Expose
    private int idPengguna;
    @SerializedName("nomor_pengaduan")
    @Expose
    private int nomorPengaduan;
    @SerializedName("pengirim")
    @Expose
    private String pengirim;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("jenis_keluhan")
    @Expose
    private JenisKeluhan jenisKeluhan;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("tgl_pengerjaan")
    @Expose
    private String tglPengerjaan;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("id_wilayah")
    @Expose
    private int idWilayah;
    @SerializedName("nama_kelurahan")
    @Expose
    private String namaKelurahan;
    @SerializedName("nama_wilayah")
    @Expose
    private String namaWilayah;
    @SerializedName("pengguna")
    @Expose
    private Pengguna pengguna;
    private final static long serialVersionUID = -1168404138856955059L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public int getNomorPengaduan() {
        return nomorPengaduan;
    }

    public void setNomorPengaduan(int nomorPengaduan) {
        this.nomorPengaduan = nomorPengaduan;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public JenisKeluhan getJenisKeluhan() {
        return jenisKeluhan;
    }

    public void setJenisKeluhan(JenisKeluhan jenisKeluhan) {
        this.jenisKeluhan = jenisKeluhan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTglPengerjaan() {
        return tglPengerjaan;
    }

    public void setTglPengerjaan(String tglPengerjaan) {
        this.tglPengerjaan = tglPengerjaan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getIdWilayah() {
        return idWilayah;
    }

    public void setIdWilayah(int idWilayah) {
        this.idWilayah = idWilayah;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public String getNamaWilayah() {
        return namaWilayah;
    }

    public void setNamaWilayah(String namaWilayah) {
        this.namaWilayah = namaWilayah;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("idKelurahan", idKelurahan).append("idPengguna", idPengguna).append("nomorPengaduan", nomorPengaduan).append("pengirim", pengirim).append("tanggal", tanggal).append("jenisKeluhan", jenisKeluhan).append("keterangan", keterangan).append("tglPengerjaan", tglPengerjaan).append("status", status).append("idWilayah", idWilayah).append("namaKelurahan", namaKelurahan).append("namaWilayah", namaWilayah).append("pengguna", pengguna).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idPengguna).append(status).append(idKelurahan).append(pengguna).append(idWilayah).append(tanggal).append(nomorPengaduan).append(jenisKeluhan).append(id).append(namaWilayah).append(pengirim).append(keterangan).append(namaKelurahan).append(tglPengerjaan).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Keluhan)) {
            return false;
        }
        Keluhan rhs = ((Keluhan) other);
        return new EqualsBuilder().append(idPengguna, rhs.idPengguna).append(status, rhs.status).append(idKelurahan, rhs.idKelurahan).append(pengguna, rhs.pengguna).append(idWilayah, rhs.idWilayah).append(tanggal, rhs.tanggal).append(nomorPengaduan, rhs.nomorPengaduan).append(jenisKeluhan, rhs.jenisKeluhan).append(id, rhs.id).append(namaWilayah, rhs.namaWilayah).append(pengirim, rhs.pengirim).append(keterangan, rhs.keterangan).append(namaKelurahan, rhs.namaKelurahan).append(tglPengerjaan, rhs.tglPengerjaan).isEquals();
    }

    @Override
    public <T> boolean isSameModelAs(@NonNull T model) {
        return equals(model);
    }

    @Override
    public <T> boolean isContentTheSameAs(@NonNull T model) {
        return equals(model);
    }
}