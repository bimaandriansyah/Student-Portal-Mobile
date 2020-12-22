package pb.pkm.pnm.ac.studentportal;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pb.pkm.pnm.ac.studentportal.fragmentkuliah.JadwalKuliah;
import pb.pkm.pnm.ac.studentportal.fragmentkuliah.KalenderAkademik;
import pb.pkm.pnm.ac.studentportal.fragmentkuliah.PresensiKuliah;

public class KuliahActivity extends FragmentActivity implements View.OnClickListener {
    Button btnLMS,btnJadwal,btnPresensi,btnKalender;

    JadwalKuliah fragmentJadwal;
    PresensiKuliah fragmentPresensi;
    KalenderAkademik fragmentKalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliah);

        btnLMS = findViewById(R.id.btn_LMS);
        btnJadwal = findViewById(R.id.btn_Jadwal);
        btnPresensi = findViewById(R.id.btn_Presensi);
        btnKalender = findViewById(R.id.btn_Kalender);

        btnLMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://lms.student.pnm.ac.id/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btnJadwal.setOnClickListener(this);
        btnPresensi.setOnClickListener(this);
        btnKalender.setOnClickListener(this);

        menuJadwal();

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

//    void menuLMS(){
//        fragmentLMS = new LMS();
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragmentSubKul,fragmentLMS);
//        ft.commit();
//    }
    void menuJadwal(){
        fragmentJadwal = new JadwalKuliah();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentJadwal);
        ft.commit();
        btnJadwal.setBackgroundResource(R.drawable.bg_btnactive);
        btnJadwal.setTextColor(this.getResources().getColor(R.color.putih));
    }
    void menuPresensi(){
        fragmentPresensi = new PresensiKuliah();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentPresensi);
        ft.commit();
    }
    void menuKalender(){
        fragmentKalender = new KalenderAkademik();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSubKul,fragmentKalender);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
//        if (view == btnLMS){
//            menuLMS();
//        }
        if (view == btnJadwal){
            menuJadwal();
            btnJadwal.setBackgroundResource(R.drawable.bg_btnactive);
            btnJadwal.setTextColor(this.getResources().getColor(R.color.putih));
            btnPresensi.setBackgroundResource(R.drawable.bgbtn);
            btnPresensi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKalender.setBackgroundResource(R.drawable.bgbtn);
            btnKalender.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnPresensi){
            menuPresensi();
            btnPresensi.setBackgroundResource(R.drawable.bg_btnactive);
            btnPresensi.setTextColor(this.getResources().getColor(R.color.putih));
            btnJadwal.setBackgroundResource(R.drawable.bgbtn);
            btnJadwal.setTextColor(this.getResources().getColor(R.color.dasar));
            btnKalender.setBackgroundResource(R.drawable.bgbtn);
            btnKalender.setTextColor(this.getResources().getColor(R.color.dasar));
        }
        if (view == btnKalender){
            menuKalender();
            btnKalender.setBackgroundResource(R.drawable.bg_btnactive);
            btnKalender.setTextColor(this.getResources().getColor(R.color.putih));
            btnPresensi.setBackgroundResource(R.drawable.bgbtn);
            btnPresensi.setTextColor(this.getResources().getColor(R.color.dasar));
            btnJadwal.setBackgroundResource(R.drawable.bgbtn);
            btnJadwal.setTextColor(this.getResources().getColor(R.color.dasar));
        }

    }
}