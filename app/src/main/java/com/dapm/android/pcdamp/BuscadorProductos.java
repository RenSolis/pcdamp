package com.dapm.android.pcdamp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import java.util.List;

public class BuscadorProductos extends Fragment {
    private Spinner spinner2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buscador_producto, container, false);

        añadirProductos();

        return view;
    }

    public void añadirProductos() {
        spinner2 = (Spinner) findViewById(R.id.input_spinner);
        ProductoLista productoList = ProductoLista.get(getActivity());
        List<Producto> productos = productoList.getCrimenes();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<Producto>(this, android.R.layout.simple_spinner_item, productos);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
}