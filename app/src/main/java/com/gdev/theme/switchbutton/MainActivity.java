package com.gdev.theme.switchbutton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.*;
import android.preference.*;
import android.os.*;
import android.view.*;
import android.widget.*;
/* 13/09/2017 created by Hendriyawan 
/* (c) GDEV */

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{
	private Switch switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //createTheme
        ThemeUtils.createTheme(this);
        setContentView(R.layout.main);
        //toolbar
        setupToolbar(R.id.toolbar);
        
        //SwitchButton
        switchButton = (Switch)findViewById(R.id.switch_theme);
        //setChecked
        switchButton.setChecked(ThemeUtils.getCheckedTheme(this));
        switchButton.setOnCheckedChangeListener(this);
        
    }
    @Override
    public void onCheckedChanged(CompoundButton compundButton, boolean isChecked)
    {
    	ThemeUtils.setTheme(this, isChecked);
    }
    //setupToolbar
    private void setupToolbar(int id)
    {
    	Toolbar toolbar = (Toolbar)findViewById(id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }
}
