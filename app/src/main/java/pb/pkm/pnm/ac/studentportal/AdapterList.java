package pb.pkm.pnm.ac.studentportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(MainActivity mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtJam.setText(list_data.get(position).get("jamKe"));
        holder.txtMatKul.setText(list_data.get(position).get("namaMatakuliah"));
        holder.txtNamaDosen.setText(list_data.get(position).get("dosen"));
        holder.txtRuang.setText(list_data.get(position).get("ruang"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtJam,txtMatKul,txtNamaDosen,txtRuang;

        public ViewHolder(View itemView) {
            super(itemView);
            txtJam = (TextView) itemView.findViewById(R.id.txtJam);
            txtMatKul = (TextView) itemView.findViewById(R.id.txtMatKul);
            txtNamaDosen = (TextView) itemView.findViewById(R.id.txtNamaDosen);
            txtRuang = (TextView) itemView.findViewById(R.id.txtRuang);
        }
    }
}
