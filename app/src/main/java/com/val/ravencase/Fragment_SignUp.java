package com.val.ravencase;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class Fragment_SignUp extends Fragment {

    DatabaseHelper myDB;
    TextInputEditText addUsername, addName, addPassword;
    TextInputLayout layoutAddUsername, layoutAddName, layoutAddPassword;
    Button buttonSignup;
    AwesomeText ShowHidePasswordSignUp;

    boolean pwd_status = true;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        myDB = new DatabaseHelper(getActivity());

        addUsername = view.findViewById(R.id.addUsername);
        addName = view.findViewById(R.id.addName);
        addPassword = view.findViewById(R.id.addPassword);
        buttonSignup = view.findViewById(R.id.buttonSignup);

        layoutAddUsername = view.findViewById(R.id.layoutAddUsername);
        layoutAddName = view.findViewById(R.id.layoutAddName);
        layoutAddPassword = view.findViewById(R.id.layoutAddPassword);

        ShowHidePasswordSignUp = (AwesomeText) view.findViewById(R.id.ShowHidePasswordSignUp);
        addPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        ShowHidePasswordSignUp.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
        Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
        addPassword.setTypeface(type);
        addPassword.setSelection(addPassword.length());

        ShowHidePasswordSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pwd_status) {
                    addPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
                    addPassword.setTypeface(type);
                    ShowHidePasswordSignUp.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    addPassword.setSelection(addPassword.length());
                } else {
                    addPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
                    addPassword.setTypeface(type);
                    ShowHidePasswordSignUp.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    addPassword.setSelection(addPassword.length());
                }
            }
        });

        AddData();

        return view;
    }

    public void AddData() {
        buttonSignup.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if (validate()) {
                            String Username = addUsername.getText().toString();
                            String Name = addName.getText().toString();
                            String Password = addPassword.getText().toString();

                            //Check in the database is there any user associated with  this email
                            if (!myDB.isUsernameExists(Username)) {

                                //Email does not exist now add new user to database
                                myDB.insertData(new User(null, Username, Name, Password));
                                Snackbar.make(buttonSignup, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                    }
                                }, Snackbar.LENGTH_LONG);
                            } else {

                                //Email exists with email input provided so show error user already exist
                                Snackbar.make(buttonSignup, "User already exists with same username ", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    }
         });
    }

        public boolean validate() {
            boolean valid = false;

            //Get values from EditText fields
            String Username = addUsername.getText().toString();
            String Name = addName.getText().toString();
            String Password = addPassword.getText().toString();

            //Handling validation for Email field
            if (Username.isEmpty()) {
                valid = false;
                layoutAddUsername.setError(" ");
            } else {
                valid = true;
                layoutAddUsername.setError(null);
            }

            //Handling validation for Email field
            if (Name.isEmpty()) {
                valid = false;
                layoutAddName.setError(" ");
            } else {
                valid = true;
                layoutAddName.setError(null);
            }

            //Handling validation for Password field
            if (Password.isEmpty()) {
                valid = false;
                layoutAddPassword.setError(" ");
            } else {
                if (Password.length() > 5) {
                    valid = true;
                    layoutAddPassword.setError(null);
                } else {
                    valid = false;
                    layoutAddPassword.setError(" ");
                }
            }

            return valid;
        }
}