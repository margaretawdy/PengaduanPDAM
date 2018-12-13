package com.pdamkotamadiun.aduin.service;

import com.pdamkotamadiun.aduin.model.keluhan.KeluhanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KeluhanService {
    @GET
    Call<KeluhanResponse> getKeluhan();

    @POST
    Call<KeluhanResponse> addKeluhan();
}
