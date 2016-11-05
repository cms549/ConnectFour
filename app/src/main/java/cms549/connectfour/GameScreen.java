package cms549.connectfour;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameScreen extends AppCompatActivity {

    TextView tvturn;
    GridView gvboard;
    int[][] board; //6 rows, 7 cols, 0 means empty, 1 means p1, -1 means p2
    ArrayList<Move> boardAsList;
    int aiDif;
    int turn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        tvturn = (TextView) findViewById(R.id.tvturn);
        gvboard = (GridView) findViewById(R.id.gvboard);

        createBlankBoard();

        gvboard.setAdapter(new BoardAdapter(this ,boardAsList ));

        gvboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Move m = boardAsList.get(position);
                if(m.player==0){
                    m.player =1;
                    m.picID = R.drawable.red_circle;
                    v.setBackground(getDrawable(m.picID));
                }
            }
        });
    }

    private void createBlankBoard() {
        boardAsList = new ArrayList<Move>(42);
        board = new int[6][7];
        int cnt =0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length;j++){
                board[i][j] =0;
                boardAsList.add(new Move(i,j,0,cnt,R.drawable.white_circle));
                cnt++;
            }
        }
    }

    public void quit(View view){
        finish();
    }


}
