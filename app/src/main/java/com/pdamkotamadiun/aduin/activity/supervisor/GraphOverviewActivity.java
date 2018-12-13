package com.pdamkotamadiun.aduin.activity.supervisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdamkotamadiun.aduin.R;

import java.util.ArrayList;
import java.util.List;

public class GraphOverviewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_overview);

        Spinner spinner = (Spinner) findViewById(R.id.activity_graph_overview_spinner_value_jenisPengaduan);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> jenisPengaduan = new ArrayList<String>();
        jenisPengaduan.add("Pipa Bocor");
        jenisPengaduan.add("Terameter 25%");
        jenisPengaduan.add("Terameter 50%");
        jenisPengaduan.add("Terameter 75%");
        jenisPengaduan.add("Air Tidak Keluar");
        jenisPengaduan.add("Air Keluar Kecil");
        jenisPengaduan.add("Air Keruh");
        jenisPengaduan.add("Ganti Meter");

        ArrayAdapter<String> dataJenisPengaduan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jenisPengaduan);

        spinner.setAdapter(dataJenisPengaduan);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

