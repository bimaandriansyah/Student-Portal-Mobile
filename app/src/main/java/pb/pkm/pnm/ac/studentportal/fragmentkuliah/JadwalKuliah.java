package pb.pkm.pnm.ac.studentportal.fragmentkuliah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import pb.pkm.pnm.ac.studentportal.AdapterList;
import pb.pkm.pnm.ac.studentportal.JadwalList;
import pb.pkm.pnm.ac.studentportal.MainActivity;
import pb.pkm.pnm.ac.studentportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JadwalKuliah#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JadwalKuliah extends Fragment {

    private RecyclerView recycleview;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    String urlJadwal = "https://bimagilang.000webhostapp.com/API/menu/jadwalkuliah/read_jadwal.php";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JadwalKuliah() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JadwalKuliah.
     */
    // TODO: Rename and change types and number of parameters
    public static JadwalKuliah newInstance(String param1, String param2) {
        JadwalKuliah fragment = new JadwalKuliah();
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
        View v = inflater.inflate(R.layout.fragment_jadwal_kuliah, container, false);

        recycleview = (RecyclerView) v.findViewById(R.id.recyclerViewDeliveryProductList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(getActivity());

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
                        JadwalList adapter = new JadwalList(getActivity(), list_data);
                        recycleview.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);

        return v;
    }
}