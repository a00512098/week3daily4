package com.example.week3daily4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateUserFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    private EditText username, password, email;
    private Button button;
    private ArrayList<User> userArrayList;

    public CreateUserFragment() {
        // Required empty public constructor
    }

    public static CreateUserFragment newInstance() {
        CreateUserFragment fragment = new CreateUserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        email = view.findViewById(R.id.email);
        button = view.findViewById(R.id.createUserBtn);
        button.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null && !isAnyFieldEmpty()) {
            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();
            String emailStr = email.getText().toString();
            User user = new User(usernameStr, passwordStr, emailStr);
            this.userArrayList.add(user);
            mListener.onCreateUserFragmentInteraction(this.userArrayList);
        } else {
            Toast.makeText(getContext(), "You need to fill all the fields first", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAnyFieldEmpty() {
        return username.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty() ||
                email.getText().toString().isEmpty();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCreateUserFragmentInteraction(ArrayList<User> users);
    }

    public void receiveUsersListInstance(ArrayList<User> users) {
        this.userArrayList = users;
    }
}
