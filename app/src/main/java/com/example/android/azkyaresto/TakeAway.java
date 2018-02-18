package com.example.android.azkyaresto;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TakeAway extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
        Toast warning = Toast.makeText(this,"Take Away",Toast.LENGTH_LONG);
        warning.show();
    }

    public void launchNext(View view) {
        Intent intent = new Intent(this,list_menu.class);
        startActivity(intent);
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.date_picker));
    }
}
