package org.dtek.andika.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class pelajaran extends AppCompatActivity {

    @BindView(R.id.pelajarancardSenin)CardView pelajarancardSenin;
    @BindView(R.id.pelajarancardSelasa)CardView pelajarancardSelasa;
    @BindView(R.id.pelajarancardRabu)CardView pelajarancardRabu;
    @BindView(R.id.pelajarancardKamis)CardView pelajarancardKamis;
    @BindView(R.id.pelajarancardJumat)CardView pelajarancardJumat;
    @BindView(R.id.pelajarancardSabtu)CardView pelajarancardSabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);

        // Delegasi Widgets
        ButterKnife.bind(this);

        pelajarancardSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranSenin.class);
                startActivity(intent);
            }
        });
        pelajarancardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranSelasa.class);
                startActivity(intent);
            }
        });
        pelajarancardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranRabu.class);
                startActivity(intent);
            }
        });
        pelajarancardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranKamis.class);
                startActivity(intent);
            }
        });
        pelajarancardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranJumat.class);
                startActivity(intent);
            }
        });
        pelajarancardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranSabtu.class);
                startActivity(intent);
            }
        });
    }
}
