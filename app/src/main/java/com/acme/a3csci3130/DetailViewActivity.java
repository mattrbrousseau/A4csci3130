package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * DetailViewActivity uses activity_detail_view.xml to view, edit and delete
 * firebase entries
 */
public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, businessField, addressField, provinceField;
    Contact receivedPersonInfo;
    MyApplicationData appState;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference("contacts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            businessField.setText(receivedPersonInfo.business);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    /**
     * When updateContact button is pressed, firebase record is updated with whatever is now
     * in the fields
     * @param v parameter v connects activity view to method
     */
    public void updateContact(View v){
        receivedPersonInfo.name=nameField.getText().toString();
        receivedPersonInfo.business=businessField.getText().toString();
        receivedPersonInfo.address=addressField.getText().toString();
        receivedPersonInfo.province=provinceField.getText().toString();
        receivedPersonInfo.number=numberField.getText().toString();

        database.child(receivedPersonInfo.uid).updateChildren(receivedPersonInfo.toMap());
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    /**
     * erase contact that firebase is currently connected to
     * @param v parameter v connects activity view to method
     */
    public void eraseContact(View v)
    {
       database.child(receivedPersonInfo.uid).removeValue();
       Intent intent=new Intent(this, MainActivity.class);
       startActivity(intent);
    }
}
