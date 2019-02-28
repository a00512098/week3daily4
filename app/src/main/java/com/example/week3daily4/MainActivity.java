package com.example.week3daily4;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CreateUserFragment.OnFragmentInteractionListener {

    private ArrayList<User> userArrayList;
    private FragmentManager fragmentManager;
    private CreateUserFragment createUserFragment;
    private ShowUsersFragment showUsersFragment;

    private static final String FRAMENT_1_TAG = "FRAMENT_1_TAG";
    private static final String FRAMENT_2_TAG = "FRAMENT_2_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userArrayList = new ArrayList<>();

        createUserFragment = CreateUserFragment.newInstance();
        showUsersFragment = ShowUsersFragment.newInstance();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.firstFragment, createUserFragment)
                .commit();

        fragmentManager.beginTransaction()
                .replace(R.id.secondFragment, showUsersFragment)
                .commit();

        createUserFragment.receiveUsersListInstance(userArrayList);
        showUsersFragment.receiveUsersListInstance(userArrayList);
    }

    @Override
    public void onCreateUserFragmentInteraction(ArrayList<User> users) {
        for (User user : users) {
            Log.d("Log.d", user.getUsername());
        }
        showUsersFragment.updateList();
    }


}
