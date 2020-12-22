package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class SettingActivity extends AppCompatActivity {
    private AlertDialog progressDialog;
    EditText edtNPMSet,edtNamaSet,edtPasswordBa,edtPasswordBa1;
    String isiPas1, isiPas2, npm,nama;
    SharedPrefManager sharedPrefManager;
    Button btnLogout,btnSimpan;
    String url = "https://bimagilang.000webhostapp.com/API/menu/akun_mahasiswa/update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sharedPrefManager = new SharedPrefManager(this);

        progressDialog = new SpotsDialog(this, R.style.Custom);

        edtNPMSet = findViewById(R.id.edtNPMSetting);
        edtNamaSet = findViewById(R.id.edtNamaSetting);
        edtPasswordBa = findViewById(R.id.edtNewPass);
        edtPasswordBa1 = findViewById(R.id.edtNewPassWord);

        npm = sharedPrefManager.getSPNpm();
        nama = sharedPrefManager.getSPNama();

        edtNPMSet.setText(npm);
        edtNamaSet.setText(nama);

        btnSimpan = (Button) findViewById(R.id.buttonSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isiPas1 = edtPasswordBa.getText().toString();
                isiPas2 = edtPasswordBa1.getText().toString();

                if (isiPas1.equals("") && isiPas2.equals("")){
                    Toast.makeText(SettingActivity.this,"Input Password",Toast.LENGTH_LONG).show();
                } else {
                    if (isiPas1.equals(isiPas2)){
                        setPassword();
                    } else {
                        Toast.makeText(SettingActivity.this,"Password baru belum sama",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        findViewById(R.id.btnBatal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    private void setPassword(){
        progressDialog.show();
        isiPas1 = edtPasswordBa.getText().toString();

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        edtNPMSet.setText("");
                        edtPasswordBa.setText("");
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                        startActivity(new Intent(SettingActivity.this, LoginActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SettingActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("npm",npm);
                params.put("password",isiPas1);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(SettingActivity.this);
        requestQueue.add(request);
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Logout");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Yakin akan keluar aplikasi ?")
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        String namaa = "";
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA,namaa);
                        startActivity(new Intent(SettingActivity.this, LoginActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();
                    }
                })
                .setNegativeButton("Batal",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}