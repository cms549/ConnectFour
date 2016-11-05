package cms549.connectfour;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseChipScreen extends AppCompatActivity {

    Spinner sp1,sp2;
    ArrayList<Chip> listOfChipColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_chip_screen);
        sp1 = (Spinner) findViewById(R.id.spchip1);
        sp2 = (Spinner) findViewById(R.id.spchip2);

        listOfChipColors = new ArrayList<Chip>();
        listOfChipColors.add(new Chip("Black", R.drawable.black_circle));
        listOfChipColors.add(new Chip("Red", R.drawable.red_circle));

        ChipImageSpinnerAdapter chips  = new ChipImageSpinnerAdapter(this, R.layout.row_with_image, listOfChipColors);
        sp1.setAdapter(chips);
        sp2.setAdapter(chips);

    }


    public void clickPlay(View view) {
        int i =sp1.getSelectedItemPosition();
        int j =sp2.getSelectedItemPosition();
        //Check that the players chips are not matching
         if(i==j){
             Toast.makeText(this, "Please select different chips.", Toast.LENGTH_SHORT).show();
             return;
         }

        Intent nextScreen = new Intent(getApplicationContext(), GameScreen.class);

        nextScreen.putExtra("chip1", listOfChipColors.get(i).id);
        nextScreen.putExtra("chip2", listOfChipColors.get(j).id);
        nextScreen.putExtra("aiDif",-1);

        //start next screen
        startActivityForResult(nextScreen,1);
    }

    public void backToMain(View view) {
        finish();
    }

    //Result listener
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == Activity.RESULT_OK && data!=null) {
            //update the stats in preferences
            //Contact c = (Contact) data.getSerializableExtra("c");

        }
        finish();
    }

}
