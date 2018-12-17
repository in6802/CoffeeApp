package com.example.halo8_pc.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int QUANTITY_MIN = 0;
    public static final int QUANTITY_MAX = 10;
    public static final int COFFEE_PRICE = 3000;

    private Button mMinusButton;
    private Button mPlusButton;
    private TextView mQuantityTextView;
    private TextView mResultTextView;
    private Button mOrderButton;

    private int mQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        //레이아웃 표시
        setContentView(R.layout.activity_main);

        // 레이아웃에서 특정 id를 인스턴스 변수와 연결
        mMinusButton = findViewById(R.id.minus_button);
        mPlusButton = findViewById(R.id.plus_button);
        mQuantityTextView = findViewById(R.id.quantity_text);
        mResultTextView = findViewById(R.id.result_text);
        mOrderButton = findViewById(R.id.order_button);

        mMinusButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Log.d(TAG, "마이너스 버튼 클릭");
                                                mQuantity--;
                                                if (mQuantity < QUANTITY_MIN) {
                                                    mQuantity = 0;
                                                }
                                                displayResult();
                                            }
                                        }
        );
        mPlusButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Log.d(TAG, "플러스 버튼 클릭");
                                               mQuantity++;
                                               if (mQuantity > QUANTITY_MAX) {
                                                   mQuantity = 10;
                                               }
                                               displayResult();
                                           }
                                       }
        );
        mOrderButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Log.d(TAG, "오더 버튼 클릭");
                                                String message = mResultTextView.getText().toString();
                                                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
    }

    private void displayResult() {
        mQuantityTextView.setText("" + mQuantity);
        int price = COFFEE_PRICE;
        String result = "가격 : " + (price * mQuantity) + "원\n감사합니다";
        mResultTextView.setText(result);
    }

    private void init() {
        mQuantity = 0;
    }
}
