package com.appz.abhi.tictactoe;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AdActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView mAdView;
    TextView textViews[], result_tv;
    Button start_btn;
    RadioButton radioButton1, radioButton2;
    RadioGroup radioGroup;
    int arr[], mod;
    int loop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, "ca-app-pub-4817615819142562~5736948620");

        // Load an ad into the AdMob banner view.
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        arr = new int[10];
        textViews = new TextView[10];
        loop = 1;

        start_btn = findViewById(R.id.start_btn_id);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        result_tv = findViewById(R.id.result_tv_id);
        textViews[1] = findViewById(R.id.textView1);
        textViews[2] = findViewById(R.id.textView2);
        textViews[3] = findViewById(R.id.textView3);
        textViews[4] = findViewById(R.id.textView4);
        textViews[5] = findViewById(R.id.textView5);
        textViews[6] = findViewById(R.id.textView6);
        textViews[7] = findViewById(R.id.textView7);
        textViews[8] = findViewById(R.id.textView8);
        textViews[9] = findViewById(R.id.textView9);
        radioGroup = findViewById(R.id.radioGroup);

        for (int i = 1; i < 10; i++) {
            textViews[i].setEnabled(false);
            textViews[i].setOnClickListener(this);
        }

        start_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.textView1:
                if (arr[1] == 0) {
                    arr[1] = 1;
                    textViews[1].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView2:
                if (arr[2] == 0) {
                    arr[2] = 1;
                    textViews[2].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView3:
                if (arr[3] == 0) {
                    arr[3] = 1;
                    textViews[3].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView4:
                if (arr[4] == 0) {
                    arr[4] = 1;
                    textViews[4].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView5:
                if (arr[5] == 0) {
                    arr[5] = 1;
                    textViews[5].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView6:
                if (arr[6] == 0) {
                    arr[6] = 1;
                    textViews[6].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView7:
                if (arr[7] == 0) {
                    arr[7] = 1;
                    textViews[7].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView8:
                if (arr[8] == 0) {
                    arr[8] = 1;
                    textViews[8].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView9:
                if (arr[9] == 0) {
                    arr[9] = 1;
                    textViews[9].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.start_btn_id:
                if (start_btn.getText().toString().equals("START")) {
                    start_btn.setText("RESET");
                    reset(view);
                    for (int i = 1; i < 10; i++)
                        textViews[i].setEnabled(true);
                    if (radioGroup.getCheckedRadioButtonId() == radioButton2.getId())
                        makeMove(loop);
                } else if (start_btn.getText().toString().equals("RESET")) {
                    start_btn.setText("START");
                    reset(view);
                }
                break;
        }
    }

    public void reset(View view) {
        loop = 1;
        for (int i = 1; i < 10; i++) {
            arr[i] = 0;
            textViews[i].setText(" ");
        }
        result_tv.setText(" ");
        for (int i = 1; i < 10; i++)
            textViews[i].setEnabled(false);
    }

    public void continue_move(View view) {
        loop++;
        if (isCompleted() == 1) {
            result_tv.setText("You Won");
            start_btn.setText("START");
            lock();
        } else if (isCompleted() == 2) {
            result_tv.setText("CPU Won");
            start_btn.setText("START");
            lock();
        } else if (loop == 10) {
            result_tv.setText("GAME DRAW");
            start_btn.setText("START");
            lock();
        }
        if (isCompleted() == -1) {
            makeMove(loop);
            if (isCompleted() == 1) {
                result_tv.setText("You Won");
                start_btn.setText("START");
                lock();
            } else if (isCompleted() == 2) {
                result_tv.setText("CPU Won");
                start_btn.setText("START");
                lock();
            } else if (loop == 10) {
                result_tv.setText("GAME DRAW");
                start_btn.setText("START");
                lock();
            }
        }
    }

    public int isCompleted() {
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == arr[3 + i]) && (arr[i] != 0) && (arr[3 + i] != 0))
                if ((arr[i] == arr[6 + i]) && (arr[6 + i] != 0))
                    return arr[i];
        }
        for (int i = 1; i < 4; i++) {
            if ((arr[i * 3 - 2] == arr[i * 3 - 1]) && (arr[i * 3 - 2] != 0) && (arr[i * 3 - 1] != 0))
                if ((arr[i * 3 - 2] == arr[i * 3]) && (arr[i * 3] != 0))
                    return arr[i * 3 - 2];
        }
        if ((arr[1] == arr[5]) && (arr[1] != 0))
            if ((arr[1] == arr[9]))
                return arr[1];
        if ((arr[3] == arr[5]) && (arr[3] != 0))
            if ((arr[3] == arr[7]))
                return arr[3];
        return -1;
    }

    public void lock() {
        for (int i = 1; i < 10; i++)
            textViews[i].setEnabled(false);
    }

    public boolean makeWinningMove() {
        //      Column checking
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == 2) && (arr[3 + i] == 2) && (arr[6 + i] == 0)) {
                arr[6 + i] = 2;
                textViews[6 + i].setText("O");
                return true;
            } else if ((arr[i] == 2) && (arr[3 + i] == 0) && (arr[6 + i] == 2)) {
                arr[3 + i] = 2;
                textViews[3 + i].setText("O");
                return true;
            } else if ((arr[i] == 0) && (arr[3 + i] == 2) && (arr[6 + i] == 2)) {
                arr[i] = 2;
                textViews[i].setText("O");
                return true;
            }
        }
        //      Row checking
        for (int i = 1; i < 4; i++) {
            if ((arr[i * 3 - 2] == 2) && (arr[i * 3 - 1] == 2) && (arr[i * 3] == 0)) {
                arr[i * 3] = 2;
                textViews[i * 3].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 2) && (arr[i * 3 - 1] == 0) && (arr[i * 3] == 2)) {
                arr[i * 3 - 1] = 2;
                textViews[i * 3 - 1].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 0) && (arr[i * 3 - 1] == 2) && (arr[i * 3] == 2)) {
                arr[i * 3 - 2] = 2;
                textViews[i * 3 - 2].setText("O");
                return true;
            }
        }
        //      Diagonal checking
        if ((arr[1] == 2) && (arr[5] == 2) && (arr[9] == 0)) {
            arr[9] = 2;
            textViews[9].setText("O");
            return true;
        } else if ((arr[1] == 2) && (arr[5] == 0) && (arr[9] == 2)) {
            arr[5] = 2;
            textViews[5].setText("O");
            return true;
        } else if ((arr[1] == 0) && (arr[5] == 2) && (arr[9] == 2)) {
            arr[1] = 2;
            textViews[1].setText("O");
            return true;
        }
        if ((arr[3] == 2) && (arr[5] == 2) && (arr[7] == 0)) {
            arr[7] = 2;
            textViews[7].setText("O");
            return true;
        } else if ((arr[3] == 2) && (arr[5] == 0) && (arr[7] == 2)) {
            arr[5] = 2;
            textViews[5].setText("O");
            return true;
        } else if ((arr[3] == 0) && (arr[5] == 2) && (arr[7] == 2)) {
            arr[3] = 2;
            textViews[3].setText("O");
            return true;
        }
        return false;
    }

    public boolean makeSavingMove() {
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == 1) && (arr[3 + i] == 1) && (arr[6 + i] == 0)) {
                arr[6 + i] = 2;
                textViews[6 + i].setText("O");
                return true;
            } else if ((arr[i] == 1) && (arr[3 + i] == 0) && (arr[6 + i] == 1)) {
                arr[3 + i] = 2;
                textViews[3 + i].setText("O");
                return true;
            } else if ((arr[i] == 0) && (arr[3 + i] == 1) && (arr[6 + i] == 1)) {
                arr[i] = 2;
                textViews[i].setText("O");
                return true;
            }
            if ((arr[i * 3 - 2] == 1) && (arr[i * 3 - 1] == 1) && (arr[i * 3] == 0)) {
                arr[i * 3] = 2;
                textViews[i * 3].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 1) && (arr[i * 3 - 1] == 0) && (arr[i * 3] == 1)) {
                arr[i * 3 - 1] = 2;
                textViews[i * 3 - 1].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 0) && (arr[i * 3 - 1] == 1) && (arr[i * 3] == 1)) {
                arr[i * 3 - 2] = 2;
                textViews[i * 3 - 2].setText("O");
                return true;
            }
        }
        if ((arr[1] == 1) && (arr[5] == 1) && (arr[9] == 0)) {
            arr[9] = 2;
            textViews[9].setText("O");
            return true;
        } else if ((arr[1] == 1) && (arr[5] == 0) && (arr[9] == 1)) {
            arr[5] = 2;
            textViews[5].setText("O");
            return true;
        } else if ((arr[1] == 0) && (arr[5] == 1) && (arr[9] == 1)) {
            arr[1] = 2;
            textViews[1].setText("O");
            return true;
        }
        if ((arr[3] == 1) && (arr[5] == 1) && (arr[7] == 0)) {
            arr[7] = 2;
            textViews[7].setText("O");
            return true;
        } else if ((arr[3] == 1) && (arr[5] == 0) && (arr[7] == 1)) {
            arr[5] = 2;
            textViews[5].setText("O");
            return true;
        } else if ((arr[3] == 0) && (arr[5] == 1) && (arr[7] == 1)) {
            arr[3] = 2;
            textViews[3].setText("O");
            return true;
        }
        return false;
    }

    // Special moves
    public boolean makeMove1() {
        mod = (int) (Math.random() * 9);
        mod++;
        if ((arr[1] == 1) && (arr[9] == 1) && (arr[5] == 2)) {
            while (true) {
                if (arr[mod] == 0 && (mod % 2 == 0))
                    break;
                mod = (int) (Math.random() * 9);
            }
            arr[mod] = 2;
            textViews[mod].setText("O");
            return true;
        }
        if ((arr[3] == 1) && (arr[7] == 1) && (arr[5] == 2)) {
            while (true) {
                if (arr[mod] == 0 && (mod % 2 == 0))
                    break;
                mod = (int) (Math.random() * 9);
            }
            arr[mod] = 2;
            textViews[mod].setText("O");
            return true;
        }
        return false;
    }

    public boolean makeMove2() {
        mod = (int) (Math.random() * 9);
        mod++;
        if (((arr[2] == 2) || (arr[4] == 2) || (arr[6] == 2) || (arr[8] == 2)) && (arr[5] == 1)) {
            if ((arr[2] == 2))
                while (arr[mod] != 0 && mod != 8) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[4] == 2))
                while (arr[mod] != 0 && mod != 6) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[6] == 2))
                while (arr[mod] != 0 && mod != 4) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[8] == 2))
                while (arr[mod] != 0 && mod != 2) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            arr[mod] = 2;
            textViews[mod].setText("O");
            return true;
        }
        return false;
    }

    public void makeMove(int moveNo) {
        moveNo--;
        switch (moveNo) {
            case 0:
                mod = (int) (Math.random() * 9);
                mod++;
                arr[mod] = 2;
                textViews[mod].setText("O");
                loop++;
                break;
            case 1:
                mod = 5;
                while (arr[mod] != 0) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
                arr[mod] = 2;
                textViews[mod].setText("O");
                loop++;
                break;
            case 2:
                if (!makeMove1()) {
                    if (!makeMove2()) {
                        mod = (int) (Math.random() * 9);
                        mod++;
                        while (arr[mod] != 0) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                        }
                        arr[mod] = 2;
                        textViews[mod].setText("O");
                    }
                }
                loop++;
                break;
            case 3:
                if (!makeWinningMove()) {
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            textViews[mod].setText("O");
                        }
                    }
                }
                loop++;
                break;
            case 4:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            textViews[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    result_tv.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    result_tv.setText("CPU Won");
                    lock();
                }
                loop++;
                break;
            case 5:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            textViews[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    result_tv.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    result_tv.setText("CPU Won");
                    lock();
                }
                loop++;
                break;
            case 6:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            textViews[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    result_tv.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    result_tv.setText("CPU Won");
                    lock();
                }
                loop++;
                break;
            case 7:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            textViews[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    result_tv.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    result_tv.setText("CPU Won");
                    lock();
                }
                loop++;
                break;
            case 8:
                for (int i = 1; i < 10; i++)
                    if (arr[i] == 0) {
                        arr[i] = 2;
                        textViews[i].setText("O");
                    }
                if (isCompleted() == 1) {
                    result_tv.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    result_tv.setText("CPU Won");
                    lock();
                } else {
                    result_tv.setText("GAME DRAW");
                    lock();
                }
                loop++;
                break;
        }
    }
    //  1 - User    2 - CPU

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
