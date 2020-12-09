package com.val.ravencase;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class Fragment_SignIn extends Fragment {

    DatabaseHelper myDB;
    TextInputEditText inputUsername, inputPassword;
    TextInputLayout layoutInputUsername, layoutInputPassword;
    Button buttonLogin;
    AwesomeText ShowHidePasswordSignIn;

    boolean pwd_status = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        myDB = new DatabaseHelper(getActivity());

        inputUsername = view.findViewById(R.id.inputUsername);
        inputPassword = view.findViewById(R.id.inputPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);

        layoutInputUsername = view.findViewById(R.id.layoutInputUsername);
        layoutInputPassword = view.findViewById(R.id.layoutInputPassword);

        ShowHidePasswordSignIn = (AwesomeText) view.findViewById(R.id.ShowHidePasswordSignIn);
        inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        ShowHidePasswordSignIn.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
        Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
        inputPassword.setTypeface(type);
        inputPassword.setSelection(inputPassword.length());

        ShowHidePasswordSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pwd_status) {
                    inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
                    inputPassword.setTypeface(type);
                    ShowHidePasswordSignIn.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    inputPassword.setSelection(inputPassword.length());
                } else {
                    inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    Typeface type = ResourcesCompat.getFont(getActivity(), R.font.montserrat);
                    inputPassword.setTypeface(type);
                    ShowHidePasswordSignIn.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    inputPassword.setSelection(inputPassword.length());
                }
            }
        });

        CheckData();

        return view;
    }

    public void CheckData() {
        buttonLogin.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //Check user input is correct or not
                        if (validate()) {

                            //Get values from EditText fields
                            String Username = inputUsername.getText().toString();
                            String Password = inputPassword.getText().toString();

                            //Authenticate user
                            User currentUser = myDB.Authenticate(new User(null, Username, null, Password));

                            //Check Authentication is successful or not
                            if (currentUser != null) {
                                Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                                //User Logged in Successfully Launch You home screen activity
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();

                            } else {

                                //User Logged in Failed
                                Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                            }

                            inputUsername.setText("");
                            inputPassword.setText("");
                        }
                    }
                    }

        );
    }

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Username = inputUsername.getText().toString();
        String Password = inputPassword.getText().toString();

        //Handling validation for Email field
        if (Username.isEmpty()) {
            valid = false;
            layoutInputUsername.setError(" ");
        } else {
            valid = true;
            layoutInputUsername.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            layoutInputPassword.setError(" ");
        } else {
            if (Password.length() > 5) {
                valid = true;
                layoutInputPassword.setError(null);
            } else {
                valid = false;
                layoutInputPassword.setError(" ");
            }
        }

        return valid;
    }
}