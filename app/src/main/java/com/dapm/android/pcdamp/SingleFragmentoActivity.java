package com.dapm.android.pcdamp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dapm.android.pcdamp.R;

public abstract class SingleFragmentoActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    protected abstract Fragment createFragmentList();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fragmento);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmento = manager.findFragmentById(R.id.fragment_container);
        Fragment fragmento2 = manager.findFragmentById(R.id.fragment_list_container);

        if (fragmento == null) {
            fragmento = createFragment();
            fragmento2 = createFragmentList();

            manager.beginTransaction()
                   .add(R.id.fragment_container, fragmento)
                   .add(R.id.fragment_list_container, fragmento2)
                   .commit();
        }
    }
}
