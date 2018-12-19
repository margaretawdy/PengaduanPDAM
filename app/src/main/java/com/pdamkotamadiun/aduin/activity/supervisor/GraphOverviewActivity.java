package com.pdamkotamadiun.aduin.activity.supervisor;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.pdamkotamadiun.aduin.R;

import java.util.ArrayList;
import java.util.List;

public class GraphOverviewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_overview);

        Spinner spinner = (Spinner) findViewById(R.id.activity_graph_overview_spinner_value_jenisPengaduan);

        AnyChartView overViewGraphJenisKeluhan = findViewById(R.id.activity_graph_overview_chartView_keluhanMasuk);
        overViewGraphJenisKeluhan.setProgressBar(findViewById(R.id.activity_graph_overview_progressBar_keluhanMasuk));

        Pie pieJenisKeluhan = AnyChart.pie();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ((Pie) pieJenisKeluhan).setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(GraphOverviewActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
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

        List<DataEntry> dataGrafikJenisKeluhan = new ArrayList<>();
        dataGrafikJenisKeluhan.add(new ValueDataEntry("Buka Baru", 800));
        dataGrafikJenisKeluhan.add(new ValueDataEntry("Tutup Rekening", 95));
        dataGrafikJenisKeluhan.add(new ValueDataEntry("Pengaduan", 1105));

        pieJenisKeluhan.data(dataGrafikJenisKeluhan);
        pieJenisKeluhan.title("Grafik Overview Jenis Keluhan yang Masuk dalam 1 Tahun");
        pieJenisKeluhan.labels().position("outside");
        pieJenisKeluhan.legend().title().enabled(true);
        pieJenisKeluhan.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d);

        pieJenisKeluhan.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        overViewGraphJenisKeluhan.setChart(pieJenisKeluhan);
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

