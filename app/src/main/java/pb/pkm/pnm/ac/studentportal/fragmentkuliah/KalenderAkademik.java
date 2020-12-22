package pb.pkm.pnm.ac.studentportal.fragmentkuliah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;

import pb.pkm.pnm.ac.studentportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KalenderAkademik#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KalenderAkademik extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KalenderAkademik() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KalenderAkademik.
     */
    // TODO: Rename and change types and number of parameters
    public static KalenderAkademik newInstance(String param1, String param2) {
        KalenderAkademik fragment = new KalenderAkademik();
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
        View v = inflater.inflate(R.layout.fragment_kalender_akademik, container, false);
        MaterialCalendarView materialCalendarView = (MaterialCalendarView) v.findViewById(R.id.calenderView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2019, 1, 1))
                .setMaximumDate(CalendarDay.from(2025, 12, 30))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        Calendar calendar = Calendar.getInstance();
        materialCalendarView.setSelectedDate(calendar);

        return v;
    }
}