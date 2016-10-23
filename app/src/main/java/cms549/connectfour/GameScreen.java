package cms549.connectfour;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    TextView tvturn;
    GridView gvboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        tvturn = (TextView) findViewById(R.id.tvturn);
        gvboard = (GridView) findViewById(R.id.gvboard);

        gvboard.setAdapter(new ImageAdapter(this));

        gvboard.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HelloGridView.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }




}
