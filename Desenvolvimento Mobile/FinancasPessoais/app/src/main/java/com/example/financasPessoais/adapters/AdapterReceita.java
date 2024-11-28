package com.example.financasPessoais.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financasPessoais.R;
import com.example.financasPessoais.model.Receita;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class AdapterReceita extends RecyclerView.Adapter<AdapterReceita.MyViewHolder> {

    private List<Receita> receitasList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public AdapterReceita(List<Receita> receitasList) {
        this.receitasList = receitasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_receita,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Receita receita = receitasList.get(position);
        holder.tvDescricaoReceita.setText(receita.getDescricao());
        holder.tvValorReceita.setText(String.format(Locale.getDefault(), "R$ %.2f", receita.getValor()));
        holder.tvDataReceita.setText(dateFormat.format(receita.getData()));

    }

    @Override
    public int getItemCount() {
        return receitasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvDescricaoReceita, tvValorReceita, tvDataReceita;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescricaoReceita = itemView.findViewById(R.id.lblDescricaoReceita);
            tvValorReceita = itemView.findViewById(R.id.lblValorReceita);
            tvDataReceita = itemView.findViewById(R.id.lblDataReceita);
        }
    }
}
