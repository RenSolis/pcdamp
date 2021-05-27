package com.dapm.android.pcdamp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaProductosFragment extends Fragment {
    private RecyclerView mCrimenesRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);

        mCrimenesRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_producto);
        mCrimenesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        actualizarUI();

        return view;
    }

    private void actualizarUI() {
        ProductoLista productoList = ProductoLista.get(getActivity());
        List<Producto> productos = productoList.getCrimenes();

        mAdapter = new CrimeAdapter(productos);
        mCrimenesRecyclerView.setAdapter(mAdapter);
    }

    private class ProductoHolder extends RecyclerView.ViewHolder {
        private TextView mNombre;
        private TextView mPrecio;
        private Producto mProducto;

        public ProductoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_lista_producto, parent, false));

            mNombre = (TextView) itemView.findViewById(R.id.producto_nombre);
            mPrecio = (TextView) itemView.findViewById(R.id.producto_precio);
        }

        public void enlazar(Producto producto) {
            mProducto = producto;
            mNombre.setText(mProducto.getNombre());
            mPrecio.setText(Double.toString(mProducto.getPrecio()));
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter {
        private List<Producto> mProductos;

        public CrimeAdapter(List<Producto> productos) {
            mProductos = productos;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ProductoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Producto producto = mProductos.get(position);

            ProductoHolder productoHolder = (ProductoHolder) holder;
            productoHolder.enlazar(producto);
        }

        @Override
        public int getItemCount() {
            return mProductos.size();
        }
    }
}
