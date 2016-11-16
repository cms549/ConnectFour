package cms549.connectfour;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AccountScreen extends AppCompatActivity {

    private TextView tvname;
    private TextView games;
    private TextView wins;
    private TextView score;
    private TextView wlratio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        tvname = (TextView) findViewById(R.id.tvname);
        games = (TextView) findViewById(R.id.gamestv);
        wins= (TextView) findViewById(R.id.winstv);
        score= (TextView) findViewById(R.id.scoretv);
        wlratio = (TextView) findViewById(R.id.wltv);



        loadFromPreference();
    }

    private void loadFromPreference() {
        // Restore preferences
        SharedPreferences myPref = getSharedPreferences("UserInfo", 0);
        String un= myPref.getString("username", null);
        int g = myPref.getInt("games",0);
        int w = myPref.getInt("wins",0);
        int s = myPref.getInt("score",0);
        int l= myPref.getInt("losses",0);


        String achievements =  myPref.getString("tokens", null);
        //should just list the numbers of the tokens you have available

        tvname.setText(un);
        games.setText(""+g);
        wins.setText(""+w);
        score.setText(""+s);
        if(g==0){
            wlratio.setText("-");
            return;
        }
        double wl = (w+0.0)/g;
        wlratio.setText(""+wl);


    }

    public void goBack(View view) {
        finish();
    }
}
