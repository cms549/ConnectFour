package cms549.connectfour;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AccountScreen extends AppCompatActivity {

    TextView tvname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        loadFromPreference();
        tvname = (TextView) findViewById(R.id.tvname);
    }

    private void loadFromPreference() {
        SharedPreferences myPref = this.getPreferences(Context.MODE_PRIVATE);
        String un = myPref.getString("username",null);
        if(un==null){
            //never logged in

        }
        else{
            tvname.setText(un);
        }

    }

    public void goBack(View view) {
        finish();
    }
}
