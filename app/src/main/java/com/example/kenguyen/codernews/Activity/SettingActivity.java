package com.example.kenguyen.codernews.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.kenguyen.codernews.R;

public class SettingActivity extends AppCompatActivity {

    Toolbar toolbar;
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
        toolbar = (Toolbar) findViewById(R.id.toolbarSetting);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,SearchActivity.class);
        startActivity(i);
        super.onBackPressed();
    }

    public void OnSaveOption(View view) {

    }
}
