package cms549.connectfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ChooseLevelScreen extends AppCompatActivity {

    Spinner sp;
    ArrayList<Chip> listOfChipColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_screen);

        sp = (Spinner) findViewById(R.id.spchip);

        listOfChipColors = new ArrayList<Chip>();
        listOfChipColors.add(new Chip("Black", R.drawable.black_circle));
        listOfChipColors.add(new Chip("Red", R.drawable.red_circle));

        ChipImageSpinnerAdapter chips  = new ChipImageSpinnerAdapter(this, R.layout.row_with_image, listOfChipColors);
        sp.setAdapter(chips);

    }


    public void clickEasy(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);
        nextScreen.putExtra("aiDif",1);

        int i=sp.getSelectedItemPosition();
        int j=0;
        if(i==0){
            j=1;
        }
        nextScreen.putExtra("chip1", listOfChipColors.get(i).id);
        nextScreen.putExtra("chip2", listOfChipColors.get(j).id);

        //start next screen
        startActivityForResult(nextScreen,1);
    }

    public void clickHard(View view) {
        //Jump to account screen
        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);
        nextScreen.putExtra("aiDif",2);

        int i=sp.getSelectedItemPosition();
        int j=0;
        if(i==0){
            j=1;
        }
        nextScreen.putExtra("chip1", listOfChipColors.get(i).id);
        nextScreen.putExtra("chip2", listOfChipColors.get(j).id);


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