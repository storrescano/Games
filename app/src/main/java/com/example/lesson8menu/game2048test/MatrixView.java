package com.example.lesson8menu.game2048test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.example.lesson8menu.R;

public class MatrixView extends TableLayout implements SwipeDirection {

    private static final int N = Matrix.N;
    private Matrix matrix;
    private final Button[][] tiles;
    private final SwipeListener swipeListener;
    private MoveListener moveListener;

    public MatrixView(Context context) {
        this(context, null);
    }

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.matrix, this);

        tiles = new Button[N][N];
        tiles[0][0] = v.findViewById(R.id.button00);
        tiles[0][1] = v.findViewById(R.id.button01);
        tiles[0][2] = v.findViewById(R.id.button02);
        tiles[0][3] = v.findViewById(R.id.button03);

        tiles[1][0] = v.findViewById(R.id.button10);
        tiles[1][1] = v.findViewById(R.id.button11);
        tiles[1][2] = v.findViewById(R.id.button12);
        tiles[1][3] = v.findViewById(R.id.button13);

        tiles[2][0] = v.findViewById(R.id.button20);
        tiles[2][1] = v.findViewById(R.id.button21);
        tiles[2][2] = v.findViewById(R.id.button22);
        tiles[2][3] = v.findViewById(R.id.button23);

        tiles[3][0] = v.findViewById(R.id.button30);
        tiles[3][1] = v.findViewById(R.id.button31);
        tiles[3][2] = v.findViewById(R.id.button32);
        tiles[3][3] = v.findViewById(R.id.button33);


        matrix = new Matrix();
        displayMatrix(matrix);

        swipeListener = new SwipeListener(context, this);
    }

    public void reset() {
        matrix = new Matrix();
        displayMatrix(matrix);
    }

    public void setMoveListener(MoveListener listener) {
        moveListener = listener;
    }


    private void displayMatrix(Matrix m) {
        final int n = Matrix.N;
        int number;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                number = m.getSpot(r, c);
                if (number == Matrix.EMPTY) {
                    tiles[r][c].setText("");
                } else {
                    tiles[r][c].setText(String.valueOf(number));
                }
                tiles[r][c].setBackgroundResource(getDrawableId(number));

            }
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        swipeListener.getGestureDetector().onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onSwipeUp() {
        Log.e("2048", "swipe up");
        handleSwipe(Direction.UP);
    }

    @Override
    public void onSwipeRight() {
        Log.e("2048", "swipe right");
        handleSwipe(Direction.RIGHT);
    }

    @Override
    public void onSwipeLeft() {
        Log.e("2048", "swipe left");
        handleSwipe(Direction.LEFT);
    }

    @Override
    public void onSwipeDown() {
        Log.e("2048", "swipe down");
        handleSwipe(Direction.DOWN);
    }

    private void handleSwipe(Direction dir) {
        int score = matrix.swipe(dir);
        boolean gameOver = matrix.isStuck();
        boolean newSquare = matrix.generate();
        displayMatrix(matrix);
        moveListener.onMove(score, gameOver, newSquare);
    }


    private int getDrawableId(int n) {
        switch (n) {
            case 2:
                return R.drawable.n_2;

            case 4:
                return R.drawable.n_4;

            case 8:
                return R.drawable.n_8;

            case 16:
                return R.drawable.n_16;

            case 32:
                return R.drawable.n_32;

            case 64:
                return R.drawable.n_64;

            case 128:
                return R.drawable.n_128;

            case 256:
                return R.drawable.n_256;

            case 512:
                return R.drawable.n_512;

            case 1024:
                return R.drawable.n_1024;

            case 2048:
                return R.drawable.n_2048;
        }
        return R.drawable.n_0;
    }
}
