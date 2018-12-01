package com.example.prekshasingla.localhackday;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;


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
    private ProgressDialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_login, container, false);

        textViewError=(TextView) rootview.findViewById(R.id.login_error);

        user_email=(EditText) rootview.findViewById(R.id.user_email);
        user_password=(EditText) rootview.findViewById(R.id.user_password);
        login=(Button)rootview.findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_email.getText().toString().equals("") && user_password.getText().toString().equals(""))
                {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Above fields cannot be blank");

                }
                else  if(user_email.getText().toString().equals(""))
                {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Name cannot be blank");

                }
                else  if(user_password.getText().toString().equals(""))
                {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Password cannot be blank");

                }

                else{
                    dialog = new ProgressDialog(getActivity());
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("Logging In ....");
                    dialog.setCancelable(false);
                    dialog.show();
                    userLoginFirebase(user_email.getText().toString(),user_password.getText().toString());
                }
            }
        });

//        rootview.findViewById(R.id.signup_text).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.login_activity_container,new SignUpFragment()).commit();
//            }
//        });

        return rootview;
    }
    private void userLoginFirebase(final String email, final String password) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                checkLogin(dataSnapshot,email,password);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    public void checkLogin(DataSnapshot dataSnapshot,String email,String password){

        String display_name=null;
        int type;
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            if (child.getKey().equals(encodeEmail(email))) {
                emailVerified=true;
                for(DataSnapshot child1 : child.getChildren()){
                    if(child1.getKey().equals("password")){
                        if(password.equals(child1.getValue().toString()))
                            passwordVerified=true;
                    }
                    if(child1.getKey().equals("name")){
                        display_name=child1.getValue()+"";
                    }

                }
            }


        }
        if(emailVerified && passwordVerified) {
            dialog.dismiss();
            getType(email);
            Toast.makeText(getActivity(), "Logged in successfully", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = getActivity().getSharedPreferences("Login", MODE_PRIVATE).edit();

            editor.putString("username", email);
            if(display_name!=null)
                editor.putString("display_name", display_name);
            editor.apply();
            emailVerified=false;
            passwordVerified=false;
            getActivity().onBackPressed();

        }else{
            dialog.dismiss();
            Toast.makeText(getActivity(), "Invalid Credentials. Please Try Again", Toast.LENGTH_LONG).show();
            emailVerified=false;
            passwordVerified=false;
        }
    }

    private void getType(String email) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("users/"+encodeEmail(email));
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for( DataSnapshot child : dataSnapshot.getChildren()){
                    if(child.getKey().equals("type")){
                        SharedPreferenceUtil.getInstance(getActivity()).setType(Integer.parseInt(""+ child.getValue()));
                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public String encodeEmail(String email){
        return email.replace(".",getString(R.string.encode_period))
                .replace("@",getString(R.string.encode_attherate))
                .replace("$",getString(R.string.encode_dollar))
                .replace("[",getString(R.string.encode_left_square_bracket))
                .replace("]",getString(R.string.encode_right_square_bracket));
    }
    public String decodeEmail(String email){
        return email.replace(getString(R.string.encode_period),".")
                .replace(getString(R.string.encode_attherate),"@")
                .replace(getString(R.string.encode_dollar),"$")
                .replace(getString(R.string.encode_left_square_bracket),"[")
                .replace(getString(R.string.encode_right_square_bracket),"]");
    }
    public  boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
