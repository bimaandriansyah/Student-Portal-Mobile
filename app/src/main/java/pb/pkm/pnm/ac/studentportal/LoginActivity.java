package pb.pkm.pnm.ac.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import dmax.dialog.SpotsDialog;

public class LoginActivity extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    EditText txtNPM, txtPassword;
    private AlertDialog progressDialog;
    String url = "https://bimagilang.000webhostapp.com/API/menu/akun_mahasiswa/read_akun.php";
    private RequestQueue mQueue;
    String npm, password, isiNPM, isiPassword, hasil;
    Button btnLogin;
    ArrayList<HashMap<String, String>> hasilNPM = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> hasilPassword = new ArrayList<HashMap<String, String>>();

    public static String md5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest;
    }
    protected void onPause() {
        super.onPause();
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btAktivasi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AktivasiActivity.class));
            }
        });

        progressDialog = new SpotsDialog(this, R.style.Custom);

        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        txtNPM = findViewById(R.id.edtNPM);
        txtPassword = findViewById(R.id.edtPassword);
        mQueue = Volley.newRequestQueue(this);

        btnLogin = (Button) findViewById(R.id.buttonMasuk);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adaInternet()) {
                    // tampilkan peta
                    cek();
                } else {
                    // tampilkan pesan
                    Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void cek() {

        if (txtNPM.getText().toString().equals("")) {
            Toast.makeText(this, "NPM masih kosong", Toast.LENGTH_LONG).show();
        } else if (txtPassword.getText().toString().equals("")) {
            Toast.makeText(this, "Password masih kosong", Toast.LENGTH_LONG).show();
        } else {
            jsonparse();
        }
    }

    private void jsonparse() {
        progressDialog.show();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                npm = result.getString("npm");
                                password = result.getString("password");

                                HashMap<String, String> dataNPM = new HashMap<>();
                                HashMap<String, String> dataPASSWORD = new HashMap<>();

                                dataNPM.put("npm", npm);
                                dataPASSWORD.put("password", password);

                                hasilNPM.add(dataNPM);
                                hasilPassword.add(dataPASSWORD);

                                isiNPM = txtNPM.getText().toString();
                                isiPassword = md5(txtPassword.getText().toString());
                                if (npm.equals(isiNPM) && password.equals(isiPassword)) {
                                    hasil = "berhasil";
                                    success();
                                    break;
                                } else {
                                    hasil = "gagal";
                                }
                            }
                            error();
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

    private boolean adaInternet() {
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }

    public void success() {
        progressDialog.dismiss();
        if (hasil.equals("berhasil")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
            sharedPrefManager.saveSPString(SharedPrefManager.SP_NPM, npm);
            startActivity(intent);
        }
    }

    public void error() {
        progressDialog.dismiss();
        if (hasil.equals("gagal")) {
            Toast.makeText(this, "NPM atau Password Salah", Toast.LENGTH_LONG).show();
        }
    }
}