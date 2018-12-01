package com.example.prekshasingla.localhackday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;


public class LoginFragment extends Fragment {
    private static final int RC_SIGN_IN = 9001;
    private static final int FB_SIGN_IN = 8001;
    TextView loginstatus;
    EditText user_email;
    EditText user_password;
    Button login;
    TextView textViewError;
    private boolean passwordVerified=false;
    private boolean emailVerified=false;
    FirebaseDatabase mDatabase;
    CheckBox showPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_login, container, false);


        return rootview;
    }



}
