package com.val.ravencase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_Dashboard extends Fragment {
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        LinearLayout imgInStock = (LinearLayout) view.findViewById(R.id.imgInStock);
        imgInStock.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @Override
            public void onClick(View view) {
                Fragment_Stock fragment_stock = new Fragment_Stock();
                bottomNav.setSelectedItemId(R.id.navigation_stock);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container, fragment_stock);
                transaction.commit();
            }
        });

        LinearLayout imgInProduction = (LinearLayout) view.findViewById(R.id.imgInProduction);
        imgInProduction.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @Override
            public void onClick(View view) {
                Fragment_Production fragment_production = new Fragment_Production();
                bottomNav.setSelectedItemId(R.id.navigation_production);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container, fragment_production);
                transaction.commit();
            }
        });

        LinearLayout imgOnPacking = (LinearLayout) view.findViewById(R.id.imgOnPacking);
        imgOnPacking.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @Override
            public void onClick(View view) {
                Fragment_Packing fragment_packing = new Fragment_Packing();
                bottomNav.setSelectedItemId(R.id.navigation_packing);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container, fragment_packing);
                transaction.commit();
            }
        });

        LinearLayout imgOnDelivery = (LinearLayout) view.findViewById(R.id.imgOnDelivery);
        imgOnDelivery.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @Override
            public void onClick(View view) {
                Fragment_Delivery fragment_delivery = new Fragment_Delivery();
                bottomNav.setSelectedItemId(R.id.navigation_delivery);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container, fragment_delivery);
                transaction.commit();
            }
        });

        return view;
    }
}