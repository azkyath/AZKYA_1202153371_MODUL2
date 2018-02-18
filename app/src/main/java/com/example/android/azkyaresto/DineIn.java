package com.example.android.azkyaresto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = DineIn.class.getSimpleName();
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
        Toast warning = Toast.makeText(this,"Dine In",Toast.LENGTH_LONG);
        warning.show();
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }

    public void launchMenu(View view){
        Intent menu = new Intent(this, list_menu.class);
        startActivity(menu);
    }

    private void showText(View view) {
        Toast review = Toast.makeText(this,mSpinnerLabel+" is chosen",Toast.LENGTH_LONG);
        review.show();
    }
}
