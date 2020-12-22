package pb.pkm.pnm.ac.studentportal.fragmentwisuda;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import pb.pkm.pnm.ac.studentportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PKLFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PKLFragment extends Fragment {
    BottomSheetBehavior sheetBehavior;
    BottomSheetDialog sheetDialog;
    View bottom_sheet;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PKLFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PKLFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PKLFragment newInstance(String param1, String param2) {
        PKLFragment fragment = new PKLFragment();
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
        //return inflater.inflate(R.layout.fragment_p_k_l, container, false);
        View v=inflater.inflate(R.layout.fragment_p_k_l, container, false);

        bottom_sheet = v.findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);

        Button button = v.findViewById(R.id.tambah);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();

            }

            private void showBottomSheetDialog() {
                View view = getLayoutInflater().inflate(R.layout.sheet, null);

                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

                (view.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sheetDialog.dismiss();
                    }
                });

                (view.findViewById(R.id.bt_subscribe)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Makasih ya sudah subscribe", Toast.LENGTH_SHORT).show();
                    }
                });

                sheetDialog = new BottomSheetDialog(getActivity());
                sheetDialog.setContentView(view);
                ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    sheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                }

                sheetDialog.show();
                sheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        sheetDialog = null;
                    }
                });
            }
        });

        return v;
    }
}