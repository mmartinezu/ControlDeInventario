package com.example.controlinventario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> {
    Context context;
    List<ProcesoValidacionDetalle> lista;

    public AdapterDatos(Context context, List<ProcesoValidacionDetalle> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_detalle, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterDatos.ViewHolder holder, int position) {
        ProcesoValidacionDetalle detalle = lista.get(position);
        holder.funcionario.setText(detalle.getFuncionario().getNombre() + " " +  detalle.getFuncionario().getApellido());
        holder.estado.setText(detalle.getEstado());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView funcionario, estado;
        public ViewHolder(View itemView) {
            super(itemView);
            funcionario = itemView.findViewById(R.id.funcionario);
            estado = itemView.findViewById(R.id.estado);
        }
    }
}
