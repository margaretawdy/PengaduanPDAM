package com.pdamkotamadiun.aduin.service;

import com.pdamkotamadiun.aduin.model.keluhan.Keluhan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KeluhanService {
    @GET("keluhan")
    Call<Keluhan> getKeluhan();

//    @POST
//    Call<KeluhanResponse> addKeluhan();
}
