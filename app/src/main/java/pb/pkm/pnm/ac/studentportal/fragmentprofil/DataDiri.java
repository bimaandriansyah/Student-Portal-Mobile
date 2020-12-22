package pb.pkm.pnm.ac.studentportal.fragmentprofil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pb.pkm.pnm.ac.studentportal.EditDataDiriActivity;
import pb.pkm.pnm.ac.studentportal.MainActivity;
import pb.pkm.pnm.ac.studentportal.R;
import pb.pkm.pnm.ac.studentportal.SharedPrefManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataDiri#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataDiri extends Fragment {
    TextView txtNIK,txtNama,txtLahir,txtJnsKelamin,txtAgama,txtAlamatAsal,txtKotaAsal,txtAlamat,txtNoHP,txtEmail;
    Button btnUbahDD;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataDiri() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataDiri.
     */
    // TODO: Rename and change types and number of parameters
    public static DataDiri newInstance(String param1, String param2) {
        DataDiri fragment = new DataDiri();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_data_diri, container, false);
        View v=inflater.inflate(R.layout.fragment_data_diri, container, false);
        txtNIK = (TextView) v.findViewById(R.id.txtNIK);
        txtNama = (TextView) v.findViewById(R.id.txtNama);
        txtLahir = (TextView) v.findViewById(R.id.txtLahir);
        txtJnsKelamin = (TextView) v.findViewById(R.id.txtJnsKelamin);
        txtAgama = (TextView) v.findViewById(R.id.txtAgama);
        txtAlamatAsal = (TextView) v.findViewById(R.id.txtAlamatAsal);
        txtKotaAsal = (TextView) v.findViewById(R.id.txtKotaAsal);
        txtAlamat = (TextView) v.findViewById(R.id.txtAlamat);
        txtNoHP = (TextView) v.findViewById(R.id.txtNoHP);
        txtEmail = (TextView) v.findViewById(R.id.txtEmail);
        Bundle b3=getArguments();
        String Nik=b3.getString("Nik");
        String Nama=b3.getString("Nama");
        String Lahir=b3.getString("Lahir");
        String TempatLahir=b3.getString("TempatLahir");
        String JnsKelamin=b3.getString("JnsKelamin");
        String Agama=b3.getString("Agama");
        String AlamatAsal=b3.getString("AlamatAsal");
        String KotaAsal=b3.getString("KotaAsal");
        String Alamat=b3.getString("Alamat");
        String NoHP=b3.getString("NoHP");
        String Email=b3.getString("Email");
        txtNIK.setText(Nik);
        txtNama.setText(Nama);
        txtLahir.setText(TempatLahir+", "+Lahir);
        txtJnsKelamin.setText(JnsKelamin);
        txtAgama.setText(Agama);
        txtAlamatAsal.setText(AlamatAsal);
        txtKotaAsal.setText(KotaAsal);
        txtAlamat.setText(Alamat);
        txtNoHP.setText(NoHP);
        txtEmail.setText(Email);

        btnUbahDD = (Button) v.findViewById(R.id.btnUbahDataDiri);
        btnUbahDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditDataDiriActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}