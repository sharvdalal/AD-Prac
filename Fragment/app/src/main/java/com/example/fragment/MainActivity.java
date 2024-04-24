package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PinkFragment.OnPinkFragmentListener{
    private static final String BLUE_TAG = "blue";
    private static final String PINK_TAG = "green";
    BlueFragment mBlueFragment;
    PinkFragment mPinkFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        mBlueFragment = (BlueFragment) fragmentManager.findFragmentByTag(BLUE_TAG);
        if (mBlueFragment == null) {
            mBlueFragment = new BlueFragment();
            fragmentManager.beginTransaction().add(R.id.blue_fragment_container, mBlueFragment, BLUE_TAG).commit();
        }

        mPinkFragment = (PinkFragment) fragmentManager.findFragmentByTag(PINK_TAG);
        if (mPinkFragment == null) {
            mPinkFragment = new PinkFragment();
            fragmentManager.beginTransaction().add(R.id.pink_fragment_container, mPinkFragment, PINK_TAG).commit();
        }
    }

    // The Activity handles receiving a message from one Fragment
    // and passing it on to the other Fragment
    @Override
    public void messageFromPinkFragment(String message) {
        mBlueFragment.youveGotMail(message);
    }
}