package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.applandeo.materialcalendarview.EventDay;
import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SwitchCompat switchCompat;
    public static boolean NighMode = false;
    ImageView imgFoto,imageprof,imagekuli,imagekues,imagepengumuman,imagepnm,imagedaful,imagewisuda,imagesetting;

    private RecyclerView recycleview;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    private RequestQueue mQueue;
    SharedPrefManager sharedPrefManager;
    TextView txtNPM, txtNama;
    String hari, isiNPM,foto, nama, npm, email, thakt, status, prodi, kelas, nohp, kotaasal, nik, lahir, jnskelamin, agama, alamatasal, alamat, tempatlahir, idAyah, namaAyah, nikAyah, ttlAyah, pendidikanAyah, pekerjaanAyah, nipAyah, pangkatAyah, penghasilanAyah, instansiAyah;
    String npmIbu, namaIbu, nikIbu, ttlIbu, pendidikanIbu, pekerjaanIbu, nipIbu, pangkatIbu, penghasilanIbu, instansiIbu;
    String namaWali, nikWali, ttlWali, pendidikanWali, nipWali, penghasilanWali, pekerjaanWali, instansiWali, pangkatWali;

    String url = "https://bimagilang.000webhostapp.com/API/menu/data_mahasiswa/read_mahasiswa.php";
    String urlAyah = "https://bimagilang.000webhostapp.com/API/menu/data_ayah/read_dataayah.php";
    String urlIbu = "https://bimagilang.000webhostapp.com/API/menu/data_ibu/read_dataibu.php";
    String urlWali = "https://bimagilang.000webhostapp.com/API/menu/data_wali/read_datawali.php";
    String urlJadwal = "https://bimagilang.000webhostapp.com/API/menu/jadwalkuliah/read_jadwalhari.php";

    public boolean doubleTapParam = false;

    @Override
    public void onBackPressed() {
        if (doubleTapParam) {
            super.onBackPressed();
            return;
        }

        this.doubleTapParam = true;
        Toast.makeText(this, "Tap sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleTapParam = false;
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageprof = findViewById(R.id.imageprof);
        imagekuli = findViewById(R.id.imagekuli);
        imagekues = findViewById(R.id.imagekues);
        imagepengumuman = findViewById(R.id.imagepengumuman);
        imagepnm = findViewById(R.id.imagepnm);
        imagedaful = findViewById(R.id.imagedaful);
        imagewisuda = findViewById(R.id.imagewisuda);
        imagesetting = findViewById(R.id.imagesetting);
        imgFoto = findViewById(R.id.imgFoto);

        final MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.calenderView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2019, 1, 1))
                .setMaximumDate(CalendarDay.from(2025, 12, 30))
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();
        Calendar calendar = Calendar.getInstance();
        materialCalendarView.setSelectedDate(calendar);

        switchCompat = findViewById(R.id.switchCompat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                NighMode = b;
                int delaytime = 200;
                compoundButton.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (NighMode){
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            imageprof.setImageResource(R.drawable.porf1);
                            imagekuli.setImageResource(R.drawable.kull1);
                            imagekues.setImageResource(R.drawable.kues1);
                            imagepengumuman.setImageResource(R.drawable.peng1);
                            imagepnm.setImageResource(R.drawable.sea1);
                            imagedaful.setImageResource(R.drawable.daft1);
                            imagewisuda.setImageResource(R.drawable.wisu1);
                            imagesetting.setImageResource(R.drawable.sett1);
                        } else {
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                    }
                },delaytime);
            }
        });

        sharedPrefManager = new SharedPrefManager(this);

        ImageSlider imageSlider = (ImageSlider) findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.pen1, "Pengisian Kuesioner Evaluasi Mengajar Dosen Semester Genap TA 2019-2020"));
        slideModels.add(new SlideModel(R.drawable.pen2, "Batas Waktu Pengisian Kuesioner Evaluasi Mengajar Dosen Semester Genap 2018-2019"));
        imageSlider.setImageList(slideModels, true);

        txtNama = (TextView) findViewById(R.id.txtNama);
        txtNPM = (TextView) findViewById(R.id.txtNPM);
        mQueue = Volley.newRequestQueue(this);

        jsonParseAyah();
        jsonParseIbu();
        jsonParseWali();
        jsonParse();
        tampil();

        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, urlJadwal, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("hari", json.getString("hari"));
                        map.put("namaMatakuliah", json.getString("namaMatakuliah"));
                        map.put("dosen", json.getString("dosen"));
                        map.put("jamKe", json.getString("jamKe"));
                        map.put("ruang", json.getString("ruang"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(MainActivity.this, list_data);
                        recycleview.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Tidak ada perkuliahan hari ini, \n Selamat Menikmati liburan !", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);

        findViewById(R.id.btnProfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
            }
        });
        findViewById(R.id.btnPengumuman).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PengumumanActivity.class));
            }
        });
        findViewById(R.id.btnDaftarUlang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DafUlActivity.class));
            }
        });
        findViewById(R.id.btnWisuda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WisudaActivity.class));
            }
        });
        findViewById(R.id.btnSetting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
            }
        });
        findViewById(R.id.btnKuliah).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), KuliahActivity.class));
            }
        });
        findViewById(R.id.btnKuesioner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), KuesionerActivity.class));
            }
        });
        findViewById(R.id.btnPNMSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://search.pnm.ac.id/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        findViewById(R.id.lihatJadwal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), KuliahActivity.class));
            }
        });
    }

    private void tampil() {
        txtNPM.setText(sharedPrefManager.getSPNpm());
        txtNama.setText(sharedPrefManager.getSPNama());
        Glide.with(MainActivity.this).load(sharedPrefManager.getSPFoto()).into(imgFoto);
        isiNPM = txtNPM.getText().toString();
    }

    public void jsonParse() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                npm = result.getString("npm");
                                nama = result.getString("nama");
                                email = result.getString("email");
                                thakt = result.getString("thnAngkatan");
                                status = result.getString("status");
                                prodi = result.getString("prodi");
                                kelas = result.getString("kelas");
                                nohp = result.getString("noHp");
                                kotaasal = result.getString("kotaAsal");
                                nik = result.getString("NIK");
                                lahir = result.getString("TTL");
                                tempatlahir = result.getString("tempatLahir");
                                jnskelamin = result.getString("jenisKelamin");
                                agama = result.getString("agama");
                                alamatasal = result.getString("alamatAsal");
                                alamat = result.getString("alamat");
                                foto = result.getString("foto");

                                if (npm.equals(isiNPM)) {
                                    txtNama.setText(nama);
                                    Glide.with(MainActivity.this).load(foto).into(imgFoto);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_EMAIL, email);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_THAKT, thakt);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_STATUS, status);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PRODI, prodi);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_KELAS, kelas);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NOHP, nohp);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_KOTAASAL, kotaasal);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIK, nik);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_LAHIR, lahir);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TEMPATLAHIR, tempatlahir);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_JNSKELAMIN, jnskelamin);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_AGAMA, agama);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ALAMATASAL, alamatasal);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ALAMAT, alamat);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_FOTO, foto);
                                    break;
                                } else {
                                    txtNama.setText("gagal");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void jsonParseAyah() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlAyah, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                npm = result.getString("npm");
                                idAyah = result.getString("iddata_ayah");
                                namaAyah = result.getString("namaAyah");
                                nikAyah = result.getString("NIK");
                                ttlAyah = result.getString("TTL");
                                pendidikanAyah = result.getString("Pendidikan");
                                pekerjaanAyah = result.getString("Pekerjaan");
                                nipAyah = result.getString("NIP");
                                pangkatAyah = result.getString("Pangkat");
                                penghasilanAyah = result.getString("Penghasilan");
                                instansiAyah = result.getString("Instansi");

                                if (npm.equals(isiNPM)) {
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMAAYAH, namaAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIKAYAH, nikAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TTLAYAH, ttlAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENDAYAH, pendidikanAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PEKERJAANAYAH, pekerjaanAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIPAYAH, nipAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PANGKAYAH, pangkatAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENGHSLAYAH, penghasilanAyah);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_INSTANSIAYAH, instansiAyah);
                                    break;
                                } else {
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void jsonParseIbu() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlIbu, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                npm = result.getString("npm");
                                namaIbu = result.getString("namaIbu");
                                nikIbu = result.getString("NIK");
                                ttlIbu = result.getString("TTL");
                                pendidikanIbu = result.getString("Pendidikan");
                                pekerjaanIbu = result.getString("Pekerjaan");
                                nipIbu = result.getString("NIP");
                                pangkatIbu = result.getString("Pangkat");
                                penghasilanIbu = result.getString("Penghasilan");
                                instansiIbu = result.getString("Instansi");

                                if (npm.equals(isiNPM)) {
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMAIBU, namaIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIKIBU, nikIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TTLIBU, ttlIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENDIBU, pendidikanIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PEKERJAANIBU, pekerjaanIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIPIBU, nipIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PANGKIBU, pangkatIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENGHSLIBU, penghasilanIbu);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_INSTANSIIBU, instansiIbu);
                                    break;
                                } else {
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void jsonParseWali() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlWali, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                npm = result.getString("npm");
                                namaWali = result.getString("namaWali");
                                nikWali = result.getString("NIK");
                                ttlWali = result.getString("TTL");
                                pendidikanWali = result.getString("Pendidikan");
                                pekerjaanWali = result.getString("Pekerjaan");
                                nipWali = result.getString("NIP");
                                pangkatWali = result.getString("Pangkat");
                                penghasilanWali = result.getString("Penghasilan");
                                instansiWali = result.getString("Instansi");

                                if (npm.equals(isiNPM)) {
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMAWALI, namaWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIKWALI, nikWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TTLWALI, ttlWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENDWALI, pendidikanWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PEKERJAANWALI, pekerjaanWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIPWALI, nipWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PANGKWALI, pangkatWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PENGHSLWALI, penghasilanWali);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_INSTANSIWALI, instansiWali);
                                    break;
                                } else {
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}