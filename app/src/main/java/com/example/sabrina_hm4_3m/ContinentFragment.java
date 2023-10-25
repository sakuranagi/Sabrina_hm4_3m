package com.example.sabrina_hm4_3m;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sabrina_hm4_3m.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnItemClickListener {

    private FragmentContinentBinding binding;
    private ContinentAdapter continentAdapter;
    private ArrayList<Continent> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        continentAdapter = new ContinentAdapter(continentList, this::onItemClick);
        binding.rvContinent.setAdapter(continentAdapter);
    }

    private void loadData() {
        continentList.add(new Continent("Евразия", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Eurasia_%28orthographic_projection%29.svg/280px-Eurasia_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("Африка", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/420px-Africa_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("Австралия", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Australia_%28orthographic_projection%29.svg/420px-Australia_%28orthographic_projection%29.svg.png"));
        continentList.add(new Continent("Северная Америка", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/420px-Location_North_America.svg.png"));
        continentList.add(new Continent("Южная Америка", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/420px-South_America_%28orthographic_projection%29.svg.png"));

    }


    @Override
    public void onItemClick(int position) {
        Continent continent = continentList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("key", position);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}