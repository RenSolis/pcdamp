package com.dapm.android.pcdamp;

import androidx.fragment.app.Fragment;

import com.dapm.android.pcdamp.ListaProductosFragment;

public class CarritoActivity extends SingleFragmentoActivity {
    @Override
    protected Fragment createFragment() {
        return new BuscadorProductos();
    }

    @Override
    protected Fragment createFragmentList() {
        return new ListaProductosFragment();
    }
}
