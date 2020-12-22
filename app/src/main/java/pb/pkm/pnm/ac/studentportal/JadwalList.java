package pb.pkm.pnm.ac.studentportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import pb.pkm.pnm.ac.studentportal.fragmentkuliah.JadwalKuliah;

public class JadwalList extends RecyclerView.Adapter<JadwalList.ViewHolder> {

    FragmentActivity context;
    ArrayList<HashMap<String, String>> list_data;

    public JadwalList(FragmentActivity jadwalKuliah, ArrayList<HashMap<String, String>> list_data) {
        this.context = jadwalKuliah;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        int rowPos = viewHolder.getAdapterPosition();

        if (rowPos == 0){
            viewHolder.txtHari.setBackgroundResource(R.drawable.table_header_cell_bg);
            viewHolder.txtMatKul.setBackgroundResource(R.drawable.table_header_cell_bg);
            viewHolder.txtNamaDosen.setBackgroundResource(R.drawable.table_header_cell_bg);
            viewHolder.txtJam.setBackgroundResource(R.drawable.table_header_cell_bg);
            viewHolder.txtRuang.setBackgroundResource(R.drawable.table_header_cell_bg);

            viewHolder.txtHari.setText("Hari");
            viewHolder.txtMatKul.setText("Mata Kuliah");
            viewHolder.txtNamaDosen.setText("Dosen");
            viewHolder.txtJam.setText("Jam");
            viewHolder.txtRuang.setText("Ruang");
        } else {
            viewHolder.txtHari.setBackgroundResource(R.drawable.table_content_cell_bg);
            viewHolder.txtMatKul.setBackgroundResource(R.drawable.table_content_cell_bg);
            viewHolder.txtNamaDosen.setBackgroundResource(R.drawable.table_content_cell_bg);
            viewHolder.txtJam.setBackgroundResource(R.drawable.table_content_cell_bg);
            viewHolder.txtRuang.setBackgroundResource(R.drawable.table_content_cell_bg);

            viewHolder.txtHari.setText(list_data.get(rowPos - 1).get("hari"));
            viewHolder.txtMatKul.setText(list_data.get(rowPos - 1).get("namaMatakuliah"));
            viewHolder.txtNamaDosen.setText(list_data.get(rowPos - 1).get("dosen"));
            viewHolder.txtJam.setText(list_data.get(rowPos - 1).get("jamKe"));
            viewHolder.txtRuang.setText(list_data.get(rowPos - 1).get("ruang"));
        }
    }

    @Override
    public int getItemCount() {
        return list_data.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtJam,txtMatKul,txtNamaDosen,txtRuang,txtHari;

        public ViewHolder(View itemView) {
            super(itemView);
            txtHari = (TextView) itemView.findViewById(R.id.txtHari);
            txtMatKul = (TextView) itemView.findViewById(R.id.txtMatKul);
            txtNamaDosen = (TextView) itemView.findViewById(R.id.txtNamaDosen);
            txtJam = (TextView) itemView.findViewById(R.id.txtJam);
            txtRuang = (TextView) itemView.findViewById(R.id.txtRuang);
        }
    }
}

