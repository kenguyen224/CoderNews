package com.example.kenguyen.codernews;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SpinnerAdapter;

public class SettingActivity extends AppCompatActivity {


    EditText mEditTextDate;
    AppCompatSpinner mASSort;
    AppCompatCheckBox mABArts;
    AppCompatCheckBox mABSports;
    AppCompatCheckBox mABFashion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mEditTextDate = (EditText) findViewById(R.id.etDate);
        mASSort = (AppCompatSpinner) findViewById(R.id.asSort);
        mABArts = (AppCompatCheckBox) findViewById(R.id.abArts);
        mASSort = (AppCompatSpinner) findViewById(R.id.asSort);
        mABSports = (AppCompatCheckBox) findViewById(R.id.abSport);
        mABFashion = (AppCompatCheckBox) findViewById(R.id.abFashion);



    }

    public void OnSaveOption(View view) {

    }
}
