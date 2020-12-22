package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.graphics.Color;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pb.pkm.pnm.ac.studentportal.fragmentprofil.DataDiri;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.DataOrangTua;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.HasilStudi;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.Keterampilan;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.Magang;
import pb.pkm.pnm.ac.studentportal.fragmentprofil.RekapPresensi;

import static pb.pkm.pnm.ac.studentportal.R.*;

public class ProfilActivity extends FragmentActivity implements View.OnClickListener {
    Button btnDataDiri,btnDataOrtu,btnRekapPresensi,btnHasilStudi,btnKeterampilan,btnMagang;
    TextView txtNama,txtEmail,txtNPM,txtThAkt,txtStatus,txtProdi,txtKelas,txtNoHP,txtKotaAsal;
    String Nik,Nama,Lahir,JnsKelamin,Agama,AlamatAsal,KotaAsal,Alamat,NoHP,Email,TempatLahir;
    String NamaAyah,PekerjaanAyah,InstansiAyah,NamaIbu,PekerjaanIbu,InstansiIbu,NamaWali,PekerjaanWali,InstansiWali;
    ImageView imgFoto;
    SharedPrefManager sharedPrefManager;

    DataDiri fragmentDataDiri;
    DataOrangTua fragmentDataOrtu;
    RekapPresensi fragmentRekap;
    HasilStudi fragmentHasil;
    Keterampilan fragmentKeterampilan;
    Magang fragmentMagang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_profil);
        sharedPrefManager = new SharedPrefManager(this);

        imgFoto = (ImageView) findViewById(id.imgFoto);

        txtNama = (TextView) findViewById(id.txtNama);
        txtEmail = (TextView) findViewById(id.txtEmail);
        txtNPM = (TextView) findViewById(id.txtNPM);
        txtThAkt = (TextView) findViewById(id.txtThAkt);
        txtStatus = (TextView) findViewById(id.txtStatus);
        txtProdi = (TextView) findViewById(id.txtProdi);
        txtKelas = (TextView) findViewById(id.txtKelas);
        txtNoHP = (TextView) findViewById(id.txtNoHP);
        txtKotaAsal = (TextView) findViewById(id.txtKotaAsal);

        btnDataDiri = findViewById(id.btn_dataDiri);
        btnDataOrtu = findViewById(id.btn_dataOrtu);
        btnRekapPresensi = findViewById(id.btn_rekapPresensi);
        btnHasilStudi = findViewById(id.btn_hasilStudi);
        btnKeterampilan = findViewById(id.btn_keterampilan);
        btnMagang = findViewById(id.btn_magang);

        btnDataDiri.setOnClickListener(this);
        btnDataOrtu.setOnClickListener(this);
        btnRekapPresensi.setOnClickListener(this);
        btnHasilStudi.setOnClickListener(this);
        btnKeterampilan.setOnClickListener(this);
        btnMagang.setOnClickListener(this);

        Nik = sharedPrefManager.getSpNik();
        Nama = sharedPrefManager.getSPNama();
        Lahir = sharedPrefManager.getSPLahir();
        TempatLahir = sharedPrefManager.getSpTempatlahir();
        JnsKelamin = sharedPrefManager.getSpJnskelamin();
        Agama = sharedPrefManager.getSpAgama();
        AlamatAsal = sharedPrefManager.getSpAlamatasal();
        KotaAsal = sharedPrefManager.getSpKotaasal();
        Alamat = sharedPrefManager.getSpAlamat();
        NoHP = sharedPrefManager.getSpNohp();
        Email = sharedPrefManager.getSPEmail();

        NamaAyah = sharedPrefManager.getSPNamaayah();
        PekerjaanAyah = sharedPrefManager.getSpPekerjaanayah();
        InstansiAyah = sharedPrefManager.getSpInstansiayah();
        NamaIbu = sharedPrefManager.getSpNamaibu();
        PekerjaanIbu = sharedPrefManager.getSpPekerjaanibu();
        InstansiIbu = sharedPrefManager.getSpInstansiibu();
        NamaWali = sharedPrefManager.getSpNamawali();
        PekerjaanWali = sharedPrefManager.getSpPekerjaanwali();
        InstansiWali = sharedPrefManager.getSpInstansiwali();



        menuDataDiri();
        tampil();

        findViewById(id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    void menuDataDiri(){
//        fragmentDataDiri = new DataDiri();
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragmentSub,fragmentDataDiri);
//        ft.commit();
        FragmentManager dataDiri = getSupportFragmentManager();
        FragmentTransaction t=dataDiri.beginTransaction();
        DataDiri m4=new DataDiri();
        Bundle b2=new Bundle();
        b2.putString("Nik",Nik);
        b2.putString("Nama",Nama);
        b2.putString("Lahir",Lahir);
        b2.putString("TempatLahir",TempatLahir);
        b2.putString("JnsKelamin",JnsKelamin);
        b2.putString("Agama",Agama);
        b2.putString("AlamatAsal",AlamatAsal);
        b2.putString("KotaAsal",KotaAsal);
        b2.putString("Alamat",Alamat);
        b2.putString("NoHP",NoHP);
        b2.putString("Email",Email);
        m4.setArguments(b2);
        t.replace(id.fragmentSub,m4);
        t.commit();
        btnDataDiri.setBackgroundResource(drawable.bg_btnactive);
        btnDataDiri.setTextColor(this.getResources().getColor(color.putih));
    }
    void menuDataOrtu(){
//        fragmentDataOrtu = new DataOrangTua();
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragmentSub,fragmentDataOrtu);
//        ft.commit();
        FragmentManager dataOrtu = getSupportFragmentManager();
        FragmentTransaction t=dataOrtu.beginTransaction();
        DataOrangTua m5=new DataOrangTua();
        Bundle b4=new Bundle();
        b4.putString("NamaAyah",NamaAyah);
        b4.putString("PekerjaanAyah",PekerjaanAyah);
        b4.putString("InstansiAyah",InstansiAyah);
        b4.putString("NamaIbu",NamaIbu);
        b4.putString("PekerjaanIbu",PekerjaanIbu);
        b4.putString("InstansiIbu",InstansiIbu);
        b4.putString("NamaWali",NamaWali);
        b4.putString("PekerjaanWali",PekerjaanWali);
        b4.putString("InstansiWali",InstansiWali);
        m5.setArguments(b4);
        t.replace(id.fragmentSub,m5);
        t.commit();
    }
    void menuRekap(){
        fragmentRekap = new RekapPresensi();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(id.fragmentSub,fragmentRekap);
        ft.commit();
    }
    void menuHasil(){
        fragmentHasil = new HasilStudi();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(id.fragmentSub,fragmentHasil);
        ft.commit();
    }
    void menuKeterampilan(){
        fragmentKeterampilan = new Keterampilan();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(id.fragmentSub,fragmentKeterampilan);
        ft.commit();
    }
    void menuMagang(){
        fragmentMagang = new Magang();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(id.fragmentSub,fragmentMagang);
        ft.commit();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        if ( view == btnDataDiri){
            menuDataDiri();
            btnDataDiri.setBackgroundResource(drawable.bg_btnactive);
            btnDataDiri.setTextColor(this.getResources().getColor(color.putih));
            btnDataOrtu.setBackgroundResource(drawable.bgbtn);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.dasar));
            btnRekapPresensi.setBackgroundResource(drawable.bgbtn);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.dasar));
            btnHasilStudi.setBackgroundResource(drawable.bgbtn);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.dasar));
            btnKeterampilan.setBackgroundResource(drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.dasar));
            btnMagang.setBackgroundResource(drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(color.dasar));
        }
        if (view == btnDataOrtu){
            menuDataOrtu();
            btnDataOrtu.setBackgroundResource(drawable.bg_btnactive);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.putih));
            btnDataDiri.setBackgroundResource(drawable.bgbtn);
            btnDataDiri.setTextColor(this.getResources().getColor(color.dasar));
            btnRekapPresensi.setBackgroundResource(drawable.bgbtn);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.dasar));
            btnHasilStudi.setBackgroundResource(drawable.bgbtn);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.dasar));
            btnKeterampilan.setBackgroundResource(drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.dasar));
            btnMagang.setBackgroundResource(drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(color.dasar));
        }
        if (view == btnRekapPresensi){
            menuRekap();
            btnRekapPresensi.setBackgroundResource(drawable.bg_btnactive);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.putih));
            btnDataDiri.setBackgroundResource(drawable.bgbtn);
            btnDataDiri.setTextColor(this.getResources().getColor(color.dasar));
            btnDataOrtu.setBackgroundResource(drawable.bgbtn);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.dasar));
            btnHasilStudi.setBackgroundResource(drawable.bgbtn);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.dasar));
            btnKeterampilan.setBackgroundResource(drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.dasar));
            btnMagang.setBackgroundResource(drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(color.dasar));
        }
        if (view == btnHasilStudi){
            menuHasil();
            btnHasilStudi.setBackgroundResource(drawable.bg_btnactive);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.putih));
            btnDataDiri.setBackgroundResource(drawable.bgbtn);
            btnDataDiri.setTextColor(this.getResources().getColor(color.dasar));
            btnRekapPresensi.setBackgroundResource(drawable.bgbtn);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.dasar));
            btnDataOrtu.setBackgroundResource(drawable.bgbtn);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.dasar));
            btnKeterampilan.setBackgroundResource(drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.dasar));
            btnMagang.setBackgroundResource(drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(color.dasar));
        }
        if (view == btnKeterampilan){
            menuKeterampilan();
            btnKeterampilan.setBackgroundResource(drawable.bg_btnactive);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.putih));
            btnDataDiri.setBackgroundResource(drawable.bgbtn);
            btnDataDiri.setTextColor(this.getResources().getColor(color.dasar));
            btnRekapPresensi.setBackgroundResource(drawable.bgbtn);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.dasar));
            btnHasilStudi.setBackgroundResource(drawable.bgbtn);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.dasar));
            btnDataOrtu.setBackgroundResource(drawable.bgbtn);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.dasar));
            btnMagang.setBackgroundResource(drawable.bgbtn);
            btnMagang.setTextColor(this.getResources().getColor(color.dasar));
        }
        if (view == btnMagang){
            menuMagang();
            btnMagang.setBackgroundResource(drawable.bg_btnactive);
            btnMagang.setTextColor(this.getResources().getColor(color.putih));
            btnDataDiri.setBackgroundResource(drawable.bgbtn);
            btnDataDiri.setTextColor(this.getResources().getColor(color.dasar));
            btnRekapPresensi.setBackgroundResource(drawable.bgbtn);
            btnRekapPresensi.setTextColor(this.getResources().getColor(color.dasar));
            btnHasilStudi.setBackgroundResource(drawable.bgbtn);
            btnHasilStudi.setTextColor(this.getResources().getColor(color.dasar));
            btnKeterampilan.setBackgroundResource(drawable.bgbtn);
            btnKeterampilan.setTextColor(this.getResources().getColor(color.dasar));
            btnDataOrtu.setBackgroundResource(drawable.bgbtn);
            btnDataOrtu.setTextColor(this.getResources().getColor(color.dasar));
        }

    }

    private void tampil() {
        txtNama.setText(sharedPrefManager.getSPNama());
        txtEmail.setText(sharedPrefManager.getSPEmail());
        txtNPM.setText(sharedPrefManager.getSPNpm());
        txtThAkt.setText(sharedPrefManager.getSpThakt());
        txtStatus.setText(sharedPrefManager.getSPStatus());
        txtProdi.setText(sharedPrefManager.getSpProdi());
        txtKelas.setText(sharedPrefManager.getSpKelas());
        txtNoHP.setText(sharedPrefManager.getSpNohp());
        txtKotaAsal.setText(sharedPrefManager.getSpKotaasal());
        Glide.with(ProfilActivity.this).load(sharedPrefManager.getSPFoto()).into(imgFoto);
    }
}