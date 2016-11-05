package cms549.connectfour;


import android.content.Intent;
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
    int aiDif;//if 0 then there is 2 players
    int turn;
    int p1color,p2color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        tvturn = (TextView) findViewById(R.id.tvturn);
        gvboard = (GridView) findViewById(R.id.gvboard);

        createBlankBoard();

        Intent i =getIntent();
        p1color = i.getIntExtra("chip1",-1);
        p2color = i.getIntExtra("chip2",-1);
        turn = 1;
        aiDif = i.getIntExtra("aiDif",-1);
        if(p1color==-1 || p2color==-1){
            p1color = R.drawable.black_circle;
            p2color=R.drawable.red_circle;
        }

        gvboard.setAdapter(new BoardAdapter(this ,boardAsList ));

        gvboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Move m = boardAsList.get(position);
                if(aiDif>-1) {
                    //there is a computer
                    if(m.player==0){
                        m.player =1;
                        m.picID = p1color;
                        v.setBackground(getDrawable(m.picID));
                        //computer go
                    }

                }else{
                    //if spot is empty
                    if(m.player==0){
                        if(turn==1){
                            //player 1 goes
                            m.player =1;
                            m.picID = p1color;
                            v.setBackground(getDrawable(m.picID));
                            turn=turn*-1;
                        }
                        else{
                            //player 2 goes
                            m.player =-1;
                            m.picID = p2color;
                            v.setBackground(getDrawable(m.picID));
                            turn=turn*-1;
                        }
                    }
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
