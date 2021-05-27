package com.dapm.android.pcdamp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductoLista {
    private static ProductoLista sProductoLista;
    private List<Producto> mProductos;

    private ProductoLista(Context context) {
        mProductos = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Producto producto = new Producto("Producto " + i, i * 3);

            mProductos.add(producto);
        }
    }

    public static ProductoLista get(Context context) {
        if (sProductoLista == null) {
            sProductoLista = new ProductoLista(context);
        }

        return sProductoLista;
    }

    public List<Producto> getCrimenes() {
        return mProductos;
    }

    public Producto get(UUID id) {
        for (Producto c: mProductos) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }
}
