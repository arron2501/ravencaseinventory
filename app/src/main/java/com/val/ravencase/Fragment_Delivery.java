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

public class Fragment_Delivery extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        LinearLayout imgDeliveryMarvel = (LinearLayout) view.findViewById(R.id.imgDeliveryMarvel);
        imgDeliveryMarvel.setOnClickListener(new View.OnClickListener() {
            // inisialisasi BottomNavigationView
            BottomNavigationView bottomNav = getActivity().findViewById(R.id.bottom_navigation);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Fragment_Delivery_Marvel fragment_delivery_marvel = new Fragment_Delivery_Marvel();
                bottomNav.setSelectedItemId(R.id.navigation_delivery);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                );
                transaction.replace(R.id.fragment_container, fragment_delivery_marvel);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}