package com.val.ravencase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_Stock extends Fragment {
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);

        LinearLayout imgStockAstronaut = (LinearLayout) view.findViewById(R.id.imgStockAstronaut);
        imgStockAstronaut.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Stock_Astronaut fragment_stock_astronaut = new Fragment_Stock_Astronaut();
                bottomNav.setSelectedItemId(R.id.navigation_stock);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_stock_astronaut);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        LinearLayout imgStockFortnite = (LinearLayout) view.findViewById(R.id.imgStockFortnite);
        imgStockFortnite.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Stock_Fortnite fragment_stock_fortnite = new Fragment_Stock_Fortnite();
                bottomNav.setSelectedItemId(R.id.navigation_stock);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_stock_fortnite);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        LinearLayout imgStockMarvel = (LinearLayout) view.findViewById(R.id.imgStockMarvel);
        imgStockMarvel.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Stock_Marvel fragment_stock_marvel = new Fragment_Stock_Marvel();
                bottomNav.setSelectedItemId(R.id.navigation_stock);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_stock_marvel);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}