package com.dapm.android.pcdamp;

import java.util.UUID;

public class Producto {
    private UUID mId;
    private String mNombre;
    private double mPrecio;

    public Producto(String nombre, double precio) {
        mId = UUID.randomUUID();
        mNombre = nombre;
        mPrecio = precio;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    public double getPrecio() {
        return mPrecio;
    }

    public void setPrecio(double mPrecio) {
        this.mPrecio = mPrecio;
    }

    public UUID getId() {
        return mId;
    }

    @Override
    public String toString() {
        return mNombre;
    }
}
