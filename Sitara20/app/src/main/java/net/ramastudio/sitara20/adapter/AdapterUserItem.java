package net.ramastudio.sitara20.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ramastudio.sitara20.R;
import net.ramastudio.sitara20.model.UserItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterUserItem extends RecyclerView.Adapter<AdapterUserItem.ViewHolder>{

    List<UserItem> userItems;
    public AdapterUserItem(List<UserItem> userItems){
        this.userItems = userItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_profil, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserItem userItem = userItems.get(position);

        holder.tvIDProfil.setText("ID Perkara: " + userItem.getId());
        holder.tvNamaProfil.setText("Nama: " + userItem.getNama());
        holder.tvEmailProfil.setText("E-Mail: " + userItem.getEmail());
    }

    @Override
    public int getItemCount() {
        return userItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_idprofil)
        TextView tvIDProfil;
        @BindView(R.id.tv_NamaProfil) TextView tvNamaProfil;
        @BindView(R.id.tv_EmailProfil) TextView tvEmailProfil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
