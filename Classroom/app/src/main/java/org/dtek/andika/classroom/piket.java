package org.dtek.andika.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class piket extends AppCompatActivity {

    @BindView(R.id.unggahLaporan)ImageButton unggahLaporan;
    @BindView(R.id.piketcardSenin)CardView piketcardSenin;
    @BindView(R.id.piketcardSelasa)CardView piketcardSelasa;
    @BindView(R.id.piketcardRabu)CardView piketcardRabu;
    @BindView(R.id.piketcardKamis)CardView piketcardKamis;
    @BindView(R.id.piketcardJumat)CardView piketcardJumat;
    @BindView(R.id.piketcardSabtu)CardView piketcardSabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piket);

        // Delegasi Widgets
        ButterKnife.bind(this);

        unggahLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, laporanPiket.class);
                startActivity(intent);
            }
        });

        piketcardSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSenin.class);
                startActivity(intent);
            }
        });
        piketcardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSelasa.class);
                startActivity(intent);
            }
        });
        piketcardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketRabu.class);
                startActivity(intent);
            }
        });
        piketcardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketKamis.class);
                startActivity(intent);
            }
        });
        piketcardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketJumat.class);
                startActivity(intent);
            }
        });
        piketcardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSabtu.class);
                startActivity(intent);
            }
        });
    }
}
