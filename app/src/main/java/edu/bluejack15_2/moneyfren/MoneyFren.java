package edu.bluejack15_2.moneyfren;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MoneyFren extends AppCompatActivity implements View.OnClickListener,ValueEventListener{

    private Firebase mRef;
    private TextView mTextCondition;
    private Button mButtonFoggy, mButtonSunny;

    ViewPager viewPager;
    CustomSwipeAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_fren);
        Firebase.setAndroidContext(this);
        viewPager = (ViewPager)findViewById(R.id.money_fren_view_pager);
        adapter = new CustomSwipeAdaptor(this);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //mButtonFoggy = (Button) findViewById(R.id.buttonFoggy);
        //mButtonSunny = (Button) findViewById(R.id.buttonSunny);
        //mTextCondition = (TextView) findViewById(R.id.textViewCondition);

        mRef = new Firebase("https://moneyfren-ee0bd.firebaseio.com/condition");

        mRef.addValueEventListener(this);
        //mButtonFoggy.setOnClickListener(this);
        //mButtonSunny.setOnClickListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String newCondition = (String) dataSnapshot.getValue();
        //mTextCondition.setText(newCondition);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }

    @Override
    public void onClick(View v) {
        /*if(v.getId() == R.id.buttonFoggy){

        }else if(v.getId() == R.id.buttonSunny){

        }*/
    }
}
