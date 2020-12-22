package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pb.pkm.pnm.ac.studentportal.fragmentkuliah.JadwalKuliah;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.Magang;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.BahasaFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.DaftarFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.KeterampilanFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.OrganisasiFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.PKLFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.PernyataanFragment;
import pb.pkm.pnm.ac.studentportal.fragmentwisuda.PrestasiFragment;

public class WisudaActivity extends FragmentActivity implements View.OnClickListener {
    Button btnDaftar,btnMagang,btnKeterampilan,btnBahasa,btnOrganisasi,btnPrestasi,btnPernyataan;

    DaftarFragment fragmentDaftar;
    BahasaFragment fragmentBahasa;
    KeterampilanFragment fragmentKeterampilan;
    OrganisasiFragment fragmentOrganisasi;
    PernyataanFragment fragmentPernyataan;
    PrestasiFragment fragmentPrestasi;
    PKLFragment fragmentMagang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisuda);

        btnBahasa = findViewById(R.id.btn_BahasaInternasional);
        btnDaftar = findViewById(R.id.btn_DaftarWisuda);
        btnKeterampilan = findViewById(R.id.btn_Keterampilan1);
        btnMagang = findViewById(R.id.btn_Magang);
        btnOrganisasi = findViewById(R.id.btn_Organisasi);
        btnPernyataan = findViewById(R.id.btn_Pernyataan);
        btnPrestasi = findViewById(R.id.btn_Prestasi);

        btnPrestasi.setOnClickListener(this);
        btnPernyataan.setOnClickListener(this);
        btnOrganisasi.setOnClickListener(this);
        btnMagang.setOnClickListener(this);
        btnKeterampilan.setOnClickListener(this);
        btnDaftar.setOnClickListener(this);
        btnBahasa.setOnClickListener(this);

        menuDaftar();

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    void menuDaftar() {
        fragmentDaftar = new DaftarFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentDaftar);
        ft.commit();
        btnDaftar.setBackgroundResource(R.drawable.bg_btnactive);
        btnDaftar.setTextColor(this.getResources().getColor(R.color.putih));
    }

    void menuBahasa() {
        fragmentBahasa = new BahasaFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentBahasa);
        ft.commit();
    }

    void menuKeterampilan() {
        fragmentKeterampilan = new KeterampilanFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentKeterampilan);
        ft.commit();
    }

    void menuOrganisasi() {
        fragmentOrganisasi = new OrganisasiFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentOrganisasi);
        ft.commit();
    }

    void menuPernyataan() {
        fragmentPernyataan = new PernyataanFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentPernyataan);
        ft.commit();
    }

    void menuPKL() {
        fragmentMagang = new PKLFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentMagang);
        ft.commit();
    }

    void menuPrestasi() {
        fragmentPrestasi = new PrestasiFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul, fragmentPrestasi);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        if (view == btnDaftar){
            menuDaftar();
            btnDaftar.setBackgroundResource(R.drawable.bg_btnactive);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnBahasa){
            menuBahasa();
            btnBahasa.setBackgroundResource(R.drawable.bg_btnactive);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.putih));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnKeterampilan){
            menuKeterampilan();
            btnKeterampilan.setBackgroundResource(R.drawable.bg_btnactive);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnOrganisasi){
            menuOrganisasi();
            btnOrganisasi.setBackgroundResource(R.drawable.bg_btnactive);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnPernyataan){
            menuPernyataan();
            btnPernyataan.setBackgroundResource(R.drawable.bg_btnactive);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnMagang){
            menuPKL();
            btnMagang.setBackgroundResource(R.drawable.bg_btnactive);
            btnMagang.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPrestasi.setBackgroundResource(R.drawable.bgbtn);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnPrestasi){
            menuPrestasi();
            btnPrestasi.setBackgroundResource(R.drawable.bg_btnactive);
            btnPrestasi.setTextColor(this.getResources().getColor(R.color.putih));
            btnBahasa.setBackgroundResource(R.drawable.bgbtn);
            btnBahasa.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKeterampilan.setBackgroundResource(R.drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnOrganisasi.setBackgroundResource(R.drawable.bgbtn);
            btnOrganisasi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnPernyataan.setBackgroundResource(R.drawable.bgbtn);
            btnPernyataan.setTextColor(this.getResources().getColor(R.color.dasar));
            btnMagang.setBackgroundResource(R.drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(R.color.dasar));
            btnDaftar.setBackgroundResource(R.drawable.bgbtn);
            btnDaftar.setTextColor(this.getResources().getColor(R.color.dasar));
        }

    }
}