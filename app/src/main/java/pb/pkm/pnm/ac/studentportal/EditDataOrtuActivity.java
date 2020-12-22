package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import dmax.dialog.SpotsDialog;

public class EditDataOrtuActivity extends AppCompatActivity {
    private AlertDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    EditText edtNIKAyah,edtNamaAyah,edtNIPAyah,edtPenghAyah,edtPekAyah,edtInstansiAyah,edtPangkatAyah,edtPendAyah,edtLahirAyah;
    EditText edtNIKIbu,edtNamaIbu,edtNIPIbu,edtPenghIbu,edtPekIbu,edtInstansiIbu,edtPangkatIbu,edtPendIbu,edtLahirIbu;
    EditText edtNIKWali,edtNamaWali,edtNIPWali,edtPenghWali,edtPekWali,edtInstansiWali,edtPangkatWali,edtPendWali,edtLahirWali;
    String npm,namaAyah,nikAyah,ttlAyah,pendidikanAyah,pekerjaanAyah,nipAyah,pangkatAyah,penghasilanAyah,instansiAyah;
    String isinamaAyah,isinikAyah,isittlAyah,isipendidikanAyah,isipekerjaanAyah,isinipAyah,isipangkatAyah,isipenghasilanAyah,isiinstansiAyah;
    String isinamaIbu,isinikIbu,isittlIbu,isipendidikanIbu,isipekerjaanIbu,isinipIbu,isipangkatIbu,isipenghasilanIbu,isiinstansiIbu;
    String isinamaWali,isinikWali,isittlWali,isipendidikanWali,isipekerjaanWali,isinipWali,isipangkatWali,isipenghasilanWali,isiinstansiWali;
    String namaIbu,nikIbu,ttlIbu,pendidikanIbu,pekerjaanIbu,nipIbu,pangkatIbu,penghasilanIbu,instansiIbu;
    String namaWali,nikWali,ttlWali,pendidikanWali,nipWali,penghasilanWali,pekerjaanWali,instansiWali,pangkatWali;
    Button btnSimpan;
    String urlEditAyah = "https://bimagilang.000webhostapp.com/API/menu/data_ayah/update_dataayah.php";
    String urlEditIbu = "https://bimagilang.000webhostapp.com/API/menu/data_ibu/update_dataibu.php";
    String urlEditWali = "https://bimagilang.000webhostapp.com/API/menu/data_wali/update_datawali.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_ortu);

        sharedPrefManager = new SharedPrefManager(this);

        progressDialog = new SpotsDialog(this, R.style.Custom);

        edtNIKAyah = findViewById(R.id.edtNIKAyah);
        edtNamaAyah = findViewById(R.id.edtNamaAyah);
        edtLahirAyah = findViewById(R.id.edtLahirAyah);
        edtPendAyah = findViewById(R.id.edtPendAyah);
        edtPekAyah = findViewById(R.id.edtPekAyah);
        edtNIPAyah = findViewById(R.id.edtNIPAyah);
        edtPangkatAyah = findViewById(R.id.edtPangkatAyah);
        edtPenghAyah = findViewById(R.id.edtPenghAyah);
        edtInstansiAyah = findViewById(R.id.edtInstansiAyah);

        edtNIKIbu = findViewById(R.id.edtNIKIbu);
        edtNamaIbu = findViewById(R.id.edtNamaIbu);
        edtLahirIbu = findViewById(R.id.edtLahirIbu);
        edtPendIbu = findViewById(R.id.edtPendIbu);
        edtPekIbu = findViewById(R.id.edtPekIbu);
        edtNIPIbu = findViewById(R.id.edtNIPIbu);
        edtPangkatIbu = findViewById(R.id.edtPangkatIbu);
        edtPenghIbu = findViewById(R.id.edtPenghIbu);
        edtInstansiIbu = findViewById(R.id.edtInstansiIbu);

        edtNIKWali = findViewById(R.id.edtNIKWali);
        edtNamaWali = findViewById(R.id.edtNamaWali);
        edtLahirWali = findViewById(R.id.edtLahirWali);
        edtPendWali = findViewById(R.id.edtPendWali);
        edtPekWali = findViewById(R.id.edtPekWali);
        edtNIPWali = findViewById(R.id.edtNIPWali);
        edtPangkatWali = findViewById(R.id.edtPangkatWali);
        edtPenghWali = findViewById(R.id.edtPenghWali);
        edtInstansiWali = findViewById(R.id.edtInstansiWali);

        npm = sharedPrefManager.getSPNpm();
        nikAyah = sharedPrefManager.getSpNikayah();
        namaAyah = sharedPrefManager.getSPNamaayah();
        ttlAyah = sharedPrefManager.getSpTtlayah();
        pendidikanAyah = sharedPrefManager.getSpPendayah();
        pekerjaanAyah = sharedPrefManager.getSpPekerjaanayah();
        nipAyah = sharedPrefManager.getSpNipayah();
        pangkatAyah = sharedPrefManager.getSpPangkayah();
        penghasilanAyah = sharedPrefManager.getSpPenghslayah();
        instansiAyah =sharedPrefManager.getSpInstansiayah();

        nikIbu = sharedPrefManager.getSpNikibu();
        namaIbu = sharedPrefManager.getSpNamaibu();
        ttlIbu = sharedPrefManager.getSpTtlibu();
        pendidikanIbu = sharedPrefManager.getSpPendibu();
        pekerjaanIbu = sharedPrefManager.getSpPekerjaanibu();
        nipIbu = sharedPrefManager.getSpNipibu();
        pangkatIbu = sharedPrefManager.getSpPangkibu();
        penghasilanIbu = sharedPrefManager.getSpPenghslibu();
        instansiIbu =sharedPrefManager.getSpInstansiibu();

        nikWali = sharedPrefManager.getSpNikwali();
        namaWali = sharedPrefManager.getSpNamawali();
        ttlWali = sharedPrefManager.getSpTtlwali();
        pendidikanWali = sharedPrefManager.getSpPendwali();
        pekerjaanWali = sharedPrefManager.getSpPekerjaanwali();
        nipWali = sharedPrefManager.getSpNipwali();
        pangkatWali = sharedPrefManager.getSpPangkwali();
        penghasilanWali = sharedPrefManager.getSpPenghslwali();
        instansiWali =sharedPrefManager.getSpInstansiwali();

        edtNIKAyah.setText(nikAyah);
        edtNamaAyah.setText(namaAyah);
        edtLahirAyah.setText(ttlAyah);
        edtPendAyah.setText(pendidikanAyah);
        edtPekAyah.setText(pekerjaanAyah);
        edtNIPAyah.setText(nipAyah);
        edtPangkatAyah.setText(pangkatAyah);
        edtPenghAyah.setText(penghasilanAyah);
        edtInstansiAyah.setText(instansiAyah);

        edtNIKIbu.setText(nikIbu);
        edtNamaIbu.setText(namaIbu);
        edtLahirIbu.setText(ttlIbu);
        edtPendIbu.setText(pendidikanIbu);
        edtPekIbu.setText(pekerjaanIbu);
        edtNIPIbu.setText(nipIbu);
        edtPangkatIbu.setText(pangkatIbu);
        edtPenghIbu.setText(penghasilanIbu);
        edtInstansiIbu.setText(instansiIbu);

        edtNIKWali.setText(nikWali);
        edtNamaWali.setText(namaWali);
        edtLahirWali.setText(ttlWali);
        edtPendWali.setText(pendidikanWali);
        edtPekWali.setText(pekerjaanWali);
        edtNIPWali.setText(nipWali);
        edtPangkatWali.setText(pangkatWali);
        edtPenghWali.setText(penghasilanWali);
        edtInstansiWali.setText(instansiWali);

        btnSimpan = (Button) findViewById(R.id.buttonSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UbahDataAyah();
                UbahDataIbu();
                UbahDataWali    ();
            }
        });

        findViewById(R.id.btnBatal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfilActivity.class));
            }
        });
    }

    private void UbahDataWali(){
        progressDialog.show();
        isinikWali = edtNIKWali.getText().toString().trim();
        isinamaWali = edtNamaWali.getText().toString().trim();
        isittlWali = edtLahirWali.getText().toString().trim();
        isipendidikanWali = edtPendWali.getText().toString().trim();
        isipekerjaanWali = edtPekWali.getText().toString().trim();
        isinipWali = edtNIPWali.getText().toString().trim();
        isipangkatWali = edtPangkatWali.getText().toString().trim();
        isipenghasilanWali = edtPenghWali.getText().toString().trim();
        isiinstansiWali = edtInstansiWali.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, urlEditWali,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        //Toast.makeText(EditDataOrtuActivity.this,npm+","+isinikAyah+","+isinamaAyah,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(EditDataOrtuActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("npm",npm);
                params.put("namaWali",isinamaWali);
                params.put("NIK",isinikWali);
                params.put("TTL",isittlWali);
                params.put("Pendidikan",isipendidikanWali);
                params.put("Pekerjaan",isipekerjaanWali);
                params.put("NIP",isinipWali);
                params.put("Pangkat",isipangkatWali);
                params.put("Penghasilan",isipenghasilanWali);
                params.put("Instansi",isiinstansiWali);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditDataOrtuActivity.this);
        requestQueue.add(request);
    }

    private void UbahDataIbu(){
        progressDialog.show();
        isinikIbu = edtNIKIbu.getText().toString().trim();
        isinamaIbu = edtNamaIbu.getText().toString().trim();
        isittlIbu = edtLahirIbu.getText().toString().trim();
        isipendidikanIbu = edtPendIbu.getText().toString().trim();
        isipekerjaanIbu = edtPekIbu.getText().toString().trim();
        isinipIbu = edtNIPIbu.getText().toString().trim();
        isipangkatIbu = edtPangkatIbu.getText().toString().trim();
        isipenghasilanIbu = edtPenghIbu.getText().toString().trim();
        isiinstansiIbu = edtInstansiIbu.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, urlEditIbu,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        //Toast.makeText(EditDataOrtuActivity.this,npm+","+isinikAyah+","+isinamaAyah,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(EditDataOrtuActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("npm",npm);
                params.put("namaIbu",isinamaIbu);
                params.put("NIK",isinikIbu);
                params.put("TTL",isittlIbu);
                params.put("Pendidikan",isipendidikanIbu);
                params.put("Pekerjaan",isipekerjaanIbu);
                params.put("NIP",isinipIbu);
                params.put("Pangkat",isipangkatIbu);
                params.put("Penghasilan",isipenghasilanIbu);
                params.put("Instansi",isiinstansiIbu);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditDataOrtuActivity.this);
        requestQueue.add(request);
    }

    private void UbahDataAyah(){
        progressDialog.show();
        isinikAyah = edtNIKAyah.getText().toString().trim();
        isinamaAyah = edtNamaAyah.getText().toString().trim();
        isittlAyah = edtLahirAyah.getText().toString().trim();
        isipendidikanAyah = edtPendAyah.getText().toString().trim();
        isipekerjaanAyah = edtPekAyah.getText().toString().trim();
        isinipAyah = edtNIPAyah.getText().toString().trim();
        isipangkatAyah = edtPangkatAyah.getText().toString().trim();
        isipenghasilanAyah = edtPenghAyah.getText().toString().trim();
        isiinstansiAyah = edtInstansiAyah.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, urlEditAyah,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        //Toast.makeText(EditDataOrtuActivity.this,npm+","+isinikAyah+","+isinamaAyah,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(EditDataOrtuActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("npm",npm);
                params.put("namaAyah",isinamaAyah);
                params.put("NIK",isinikAyah);
                params.put("TTL",isittlAyah);
                params.put("Pendidikan",isipendidikanAyah);
                params.put("Pekerjaan",isipekerjaanAyah);
                params.put("NIP",isinipAyah);
                params.put("Pangkat",isipangkatAyah);
                params.put("Penghasilan",isipenghasilanAyah);
                params.put("Instansi",isiinstansiAyah);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditDataOrtuActivity.this);
        requestQueue.add(request);
    }
}