package com.val.ravencase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_Production extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_production, container, false);

        LinearLayout imgProductionOnePiece = (LinearLayout) view.findViewById(R.id.imgProductionOnePiece);
        imgProductionOnePiece.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Production_One_Piece fragment_production_one_piece = new Fragment_Production_One_Piece();
                bottomNav.setSelectedItemId(R.id.navigation_production);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_production_one_piece);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        LinearLayout imgProductionNaruto = (LinearLayout) view.findViewById(R.id.imgProductionNaruto);
        imgProductionNaruto.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Production_Naruto fragment_production_naruto = new Fragment_Production_Naruto();
                bottomNav.setSelectedItemId(R.id.navigation_production);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_production_naruto);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        LinearLayout imgProductionPUBG = (LinearLayout) view.findViewById(R.id.imgProductionPUBG);
        imgProductionPUBG.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Production_PUBG fragment_production_pubg = new Fragment_Production_PUBG();
                bottomNav.setSelectedItemId(R.id.navigation_production);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_production_pubg);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}