package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * CreateContactActivity uses the activity_create_contact_activity.xml
 * to create a new Contact object which is passed to firebase
 */
public class CreateContactAcitivity extends Activity {
    DatabaseReference database = FirebaseDatabase.getInstance().getReference("contacts");


    private Button submitButton;
    private EditText nameField, numberField, businessField, addressField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    /**
     * Takes values that are currently in field and once button is pressed, creates a new firebase
     * object of given contact
     * @param v parameter v connects activity view to method
     */
    public void submitInfoButton(View v) {
        //DatabaseReference ref = contact.child("contact");
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name_value = nameField.getText().toString();
        String number_value = numberField.getText().toString();
        String business_value = businessField.getText().toString();
        String address_value = addressField.getText().toString();
        String province_value = provinceField.getText().toString();
        Contact person = new Contact(personID, name_value, number_value,address_value,province_value,business_value);

        database.child(personID).setValue(person);
        finish();
    }
}
