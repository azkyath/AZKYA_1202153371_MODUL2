package com.example.android.azkyaresto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String dine;
    private String take;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast welcome = Toast.makeText(this,"Azkya_1202153371",Toast.LENGTH_LONG);
        welcome.show();
    }

    public void launchNext(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // dine in
                {
                    dine = (String)getString(R.string.dine_in);
                    Toast warning = Toast.makeText(this,"Dine In",Toast.LENGTH_LONG);
                    warning.show();
                }
                break;
            case R.id.radioButton2:
                if (checked)
                    // take away
                {
                    take = (String)getString(R.string.take_away);
                    Toast warning = Toast.makeText(this,"Take Away",Toast.LENGTH_LONG);
                    warning.show();
                }
                break;
            default:
                break;
        }
    }

    public void launchOrder(View view){
        if (dine!=null){
            Intent dine = new Intent(this, DineIn.class);
            startActivity(dine);
        }else if (take!=null){
            Intent take = new Intent(this, TakeAway.class);
            startActivity(take);
        }else{
            Toast warning = Toast.makeText(this,"Nothing is chosen",Toast.LENGTH_LONG);
            warning.show();
        }
    }
}
