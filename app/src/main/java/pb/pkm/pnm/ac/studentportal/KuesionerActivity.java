package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pb.pkm.pnm.ac.studentportal.fragmentkuesioner.EvaluasiDosen;
import pb.pkm.pnm.ac.studentportal.fragmentkuesioner.LayananMahasiswa;
import pb.pkm.pnm.ac.studentportal.fragmentkuesioner.VisiMisi;
import pb.pkm.pnm.ac.studentportal.fragmentkuliah.JadwalKuliah;

public class KuesionerActivity extends FragmentActivity implements View.OnClickListener {
    Button btnEvaluasiDosen,btnVisiMisi,btnLayaMahasiswa;

    EvaluasiDosen fragmentEvaluasiDosen;
    LayananMahasiswa fragmentLayaMahasiswa;
    VisiMisi fragmentVisiMisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuesioner);

        btnEvaluasiDosen = findViewById(R.id.btn_EvaluasiDosen);
        btnVisiMisi = findViewById(R.id.btn_PemVisiMisi);
        btnLayaMahasiswa = findViewById(R.id.btn_LayananMhs);

        btnLayaMahasiswa.setOnClickListener(this);
        btnVisiMisi.setOnClickListener(this);
        btnEvaluasiDosen.setOnClickListener(this);

        menuEvalDosen();

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    void menuEvalDosen(){
        fragmentEvaluasiDosen = new EvaluasiDosen();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentEvaluasiDosen);
        ft.commit();
        btnEvaluasiDosen.setBackgroundResource(R.drawable.bg_btnactive);
        btnEvaluasiDosen.setTextColor(this.getResources().getColor(R.color.putih));
    }

    void menuVisiMisi(){
        fragmentVisiMisi = new VisiMisi();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentVisiMisi);
        ft.commit();
    }

    void menuLayaMahasiswa(){
        fragmentLayaMahasiswa = new LayananMahasiswa();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentLayaMahasiswa);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        if (view == btnEvaluasiDosen){
            menuEvalDosen();
            btnEvaluasiDosen.setBackgroundResource(R.drawable.bg_btnactive);
            btnEvaluasiDosen.setTextColor(this.getResources().getColor(R.color.putih));
            btnVisiMisi.setBackgroundResource(R.drawable.bgbtn);
            btnVisiMisi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnLayaMahasiswa.setBackgroundResource(R.drawable.bgbtn);
            btnLayaMahasiswa.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnVisiMisi){
            menuVisiMisi();
            btnVisiMisi.setBackgroundResource(R.drawable.bg_btnactive);
            btnVisiMisi.setTextColor(this.getResources().getColor(R.color.putih));
            btnEvaluasiDosen.setBackgroundResource(R.drawable.bgbtn);
            btnEvaluasiDosen.setTextColor(this.getResources().getColor(R.color.dasar));
            btnLayaMahasiswa.setBackgroundResource(R.drawable.bgbtn);
            btnLayaMahasiswa.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnLayaMahasiswa){
            menuLayaMahasiswa();
            btnLayaMahasiswa.setBackgroundResource(R.drawable.bg_btnactive);
            btnLayaMahasiswa.setTextColor(this.getResources().getColor(R.color.putih));
            btnVisiMisi.setBackgroundResource(R.drawable.bgbtn);
            btnVisiMisi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnEvaluasiDosen.setBackgroundResource(R.drawable.bgbtn);
            btnEvaluasiDosen.setTextColor(this.getResources().getColor(R.color.dasar));
        }

    }
}