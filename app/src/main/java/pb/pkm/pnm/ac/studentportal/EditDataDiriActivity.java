package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class EditDataDiriActivity extends AppCompatActivity {
    EditText edtNPM,edtNIK,edtNama,edtTempatLahir,edtTtl,edtJnsKlm,edtAgama,edtKotaAsal,edtAlamatAsal,edtAlamat,edtThAkt,edtNoHp,edtEmail;
    Button btnSimpan,btnBatal;
    SharedPrefManager sharedPrefManager;
    RadioGroup radioJenisKelamin;
    RadioButton rbLakilaki,rbPerempuan;
    private AlertDialog progressDialog;
    String stringNPM,stringNIK,stringNama,stringTempatLahir,stringTtl,stringJnsKlm,stringAgama,
            stringKotaAsal,stringAlamatAsal,stringAlamat,stringThAkt,stringNoHp,stringEmail;
    String url = "https://bimagilang.000webhostapp.com/API/menu/data_mahasiswa/update_mahasiswa.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_diri);

        sharedPrefManager = new SharedPrefManager(this);
        progressDialog = new SpotsDialog(this, R.style.Custom);

        findViewById(R.id.btnBatal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfilActivity.class));
            }
        });

        rbLakilaki = findViewById(R.id.rbLakilaki);
        rbPerempuan = findViewById(R.id.rbPerempuan);
        radioJenisKelamin = findViewById(R.id.radioJenisKelamin);
        edtNPM = findViewById(R.id.edtNPM);
        edtNIK = findViewById(R.id.edtNIK);
        edtNama = findViewById(R.id.edtNama);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTtl = findViewById(R.id.edtTtl);
        edtAgama = findViewById(R.id.edtAgama);
        edtKotaAsal = findViewById(R.id.edtKotaAsal);
        edtAlamatAsal = findViewById(R.id.edtAlamatAsal);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtThAkt = findViewById(R.id.edtThAkt);
        edtNoHp = findViewById(R.id.edtNoHp);
        edtEmail = findViewById(R.id.edtEmail);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        edtNPM.setText(sharedPrefManager.getSPNpm());
        edtNIK.setText(sharedPrefManager.getSpNik());
        edtNama.setText(sharedPrefManager.getSPNama());
        edtTempatLahir.setText(sharedPrefManager.getSpTempatlahir());
        edtTtl.setText(sharedPrefManager.getSPLahir());
        edtAgama.setText(sharedPrefManager.getSpAgama());
        edtKotaAsal.setText(sharedPrefManager.getSpKotaasal());
        edtAlamatAsal.setText(sharedPrefManager.getSpAlamatasal());
        edtAlamat.setText(sharedPrefManager.getSpAlamat());
        edtThAkt.setText(sharedPrefManager.getSpThakt());
        edtNoHp.setText(sharedPrefManager.getSpNohp());
        edtEmail.setText(sharedPrefManager.getSPEmail());

//        RadioButton rblaki;
//        rblaki = (RadioButton) findViewById(R.id.rbLakilaki);
//        rblaki.isChecked();

        if (sharedPrefManager.getSpJnskelamin().equals("Laki - laki")){
            rbLakilaki.isChecked();
        } else if (sharedPrefManager.getSpJnskelamin().equals("Perempuan")){
            rbPerempuan.isChecked();
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioJenisKelamin.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rbLakilaki:
                        stringJnsKlm = "Laki - laki";
                        break;
                    case R.id.rbPerempuan :
                        stringJnsKlm = "Perempuan";
                        break;
                }
                Update();
            }
        });
    }

    private void Update() {
        progressDialog.show();
        stringNPM = edtNPM.getText().toString().trim();
        stringNIK = edtNIK.getText().toString().trim();
        stringNama = edtNama.getText().toString().trim();
        stringTempatLahir = edtTempatLahir.getText().toString().trim();
        stringTtl = edtTtl.getText().toString().trim();
        stringAgama = edtAgama.getText().toString().trim();
        stringKotaAsal = edtKotaAsal.getText().toString().trim();
        stringAlamatAsal = edtAlamatAsal.getText().toString().trim();
        stringAlamat = edtAlamat.getText().toString().trim();
        stringThAkt = edtThAkt.getText().toString().trim();
        stringNoHp = edtNoHp.getText().toString().trim();
        stringEmail = edtEmail.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        Toast.makeText(EditDataDiriActivity.this, "Update Data Sukses", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(EditDataDiriActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("npm",stringNPM);
                params.put("nama",stringNama);
                params.put("NIK",stringNIK);
                params.put("TTL",stringTtl);
                params.put("tempatLahir",stringTempatLahir);
                params.put("jenisKelamin",stringJnsKlm);
                params.put("agama",stringAgama);
                params.put("alamat",stringAlamat);
                params.put("thnAngkatan",stringThAkt);
                params.put("email",stringEmail);
                params.put("kotaAsal",stringKotaAsal);
                params.put("noHp",stringNoHp);
                params.put("alamatAsal",stringAlamatAsal);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditDataDiriActivity.this);
        requestQueue.add(request);
    }
}