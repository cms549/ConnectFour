package cms549.connectfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void goToAccount(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), AccountScreen.class);

        //start next screen
        startActivityForResult(nextScreen,3);

    }

    public void goToChooseLevel(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), ChooseLevelScreen.class);

        //start next screen
        startActivityForResult(nextScreen,1);

    }

    public void goToChooseChip(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), ChooseChipScreen.class);


        //start next screen
        startActivityForResult(nextScreen,2);

    }
}
