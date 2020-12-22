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
import pb.pkm.pnm.ac.studentportal.EditDataOrtuActivity;
import pb.pkm.pnm.ac.studentportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataOrangTua#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataOrangTua extends Fragment {
    TextView txtNamaAyah,txtKerjaAyah,txtInstansiAyah,txtNamaIbu,txtKerjaIbu,txtInstansiIbu,txtNamaWali,txtKerjaWali,txtInstansiWali;
    Button btnUbahDO;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataOrangTua() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataOrangTua.
     */
    // TODO: Rename and change types and number of parameters
    public static DataOrangTua newInstance(String param1, String param2) {
        DataOrangTua fragment = new DataOrangTua();
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
        //return inflater.inflate(R.layout.fragment_data_orang_tua, container, false);
        View v = inflater.inflate(R.layout.fragment_data_orang_tua,container,false);
        txtNamaAyah = (TextView) v.findViewById(R.id.txtNamaAyah);
        txtKerjaAyah = (TextView) v.findViewById(R.id.txtKerjaAyah);
        txtInstansiAyah = (TextView) v.findViewById(R.id.txtInstansiAyah);
        txtNamaIbu = (TextView) v.findViewById(R.id.txtNamaIbu);
        txtKerjaIbu = (TextView) v.findViewById(R.id.txtKerjaIbu);
        txtInstansiIbu = (TextView) v.findViewById(R.id.txtInstansiIbu);
        txtNamaWali = (TextView) v.findViewById(R.id.txtNamaWali);
        txtKerjaWali = (TextView) v.findViewById(R.id.txtKerjaWali);
        txtInstansiWali = (TextView) v.findViewById(R.id.txtInstansiWali);


        Bundle b3=getArguments();

        String NamaAyah=b3.getString("NamaAyah");
        String KerjaAyah=b3.getString("PekerjaanAyah");
        String InstansiAyah=b3.getString("InstansiAyah");

        String NamaIbu=b3.getString("NamaIbu");
        String KerjaIbu=b3.getString("PekerjaanIbu");
        String InstansiIbu=b3.getString("InstansiIbu");

        String NamaWali=b3.getString("NamaWali");
        String KerjaWali=b3.getString("PekerjaanWali");
        String InstansiWali=b3.getString("InstansiWali");

        txtNamaAyah.setText(NamaAyah);
        txtKerjaAyah.setText(KerjaAyah);
        txtInstansiAyah.setText(InstansiAyah);
        txtNamaIbu.setText(NamaIbu);
        txtKerjaIbu.setText(KerjaIbu);
        txtInstansiIbu.setText(InstansiIbu);
        txtNamaWali.setText(NamaWali);
        txtKerjaWali.setText(KerjaWali);
        txtInstansiWali.setText(InstansiWali);

        btnUbahDO = (Button) v.findViewById(R.id.btnUbahDataOrtu);
        btnUbahDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditDataOrtuActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}