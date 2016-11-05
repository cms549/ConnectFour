package cms549.connectfour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseChipScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_chip_screen);

    }


    public void clickPlay(View view) {
        //Check that the players chips are selected

        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);

        //start next screen
        startActivityForResult(nextScreen,1);
    }

    //Result listener
}
