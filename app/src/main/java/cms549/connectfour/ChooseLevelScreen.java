package cms549.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ChooseLevelScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_screen);
    }


    public void clickEasy(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);
        nextScreen.putExtra("dif",1);
        nextScreen.putExtra("players",1);
        //start next screen
        startActivityForResult(nextScreen,1);
    }

    public void clickHard(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);
        nextScreen.putExtra("dif",2);
        nextScreen.putExtra("players",1);
        //start next screen
        startActivityForResult(nextScreen,1);
    }

    public void goBack(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
    }
}