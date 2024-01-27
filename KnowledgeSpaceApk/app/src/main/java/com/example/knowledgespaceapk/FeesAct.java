package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FeesAct extends AppCompatActivity {
    EditText txt1;
    EditText txt2;
    int Row;
    int Col;
    int count, i, j;
    String str;
    String stm;
    Button Create;
    TableLayout TabLayout_Create;
    TableLayout TabLayout_Show;
    Button Show;
    MaterialButton academicsBtn,feeHistoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
        txt1 = (EditText) findViewById(R.id.editText1);
        txt2 = (EditText) findViewById(R.id.editText2);
        Create = (Button) findViewById(R.id.button1);
        Show = (Button) findViewById(R.id.Show);
        TabLayout_Create = (TableLayout) findViewById(R.id.TableLayout);
        TabLayout_Show = (TableLayout) findViewById(R.id.TableLayout2);
        feeHistoryBtn = findViewById(R.id.feesHistoryBtn);

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = txt1.getText().toString();
                stm = txt2.getText().toString();

                Row = Integer.parseInt(str);
                Col = Row = Integer.parseInt(stm);

                Toast.makeText(getApplicationContext(),
                        str, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),
                        stm, Toast.LENGTH_SHORT).show();

                // TextView[] txt;

                for (i = 1; i <= Row; i++) {
                    final TableRow row = new TableRow(getApplicationContext());
                    if (i % 2 == 0) {
                        row.setBackgroundColor(Color.MAGENTA);
                    } else {
                        row.setBackgroundColor(Color.GRAY);
                    }

                    for (j = 1; j <= Col; j++) {

                        final EditText txt = new EditText(getApplicationContext());
                        txt.setTextColor(Color.GREEN);
                        txt.setTextSize(TypedValue.COMPLEX_UNIT_PT, 8);
                        txt.setTypeface(Typeface.SERIF, Typeface.BOLD);
                        txt.setGravity(Gravity.LEFT);
                        txt.setText("C" + i + j + " ");

                        row.addView(txt);
                    }
                    TabLayout_Create.addView(row);

                }
        }
        });

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub

                for (i = 0; i < Row; i++) {
                    final TableRow row = (TableRow) TabLayout_Create.getChildAt(i);
                    final TableRow row1 = new TableRow(getApplicationContext());

                    if (i % 2 == 0) {
                        row1.setBackgroundColor(Color.YELLOW);
                    } else {
                        row1.setBackgroundColor(Color.RED);
                    }
                    for (j = 0; j < Col; j++) {
                        final EditText etxt = (EditText) row.getChildAt(j);

                        final TextView txt = new TextView(getApplicationContext());
                        txt.setTextColor(Color.GREEN);
                        txt.setTextSize(TypedValue.COMPLEX_UNIT_PT, 8);
                        txt.setTypeface(Typeface.SERIF, Typeface.BOLD);
                        txt.setGravity(Gravity.LEFT);
                        txt.setText(etxt.getText());

                        row1.addView(txt);
                    }
                    TabLayout_Show.addView(row1);
                }
        }
        });

        feeHistoryBtnClicked();
    }

    private void feeHistoryBtnClicked() {
        feeHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FeesHistoryAct.class));
            }
        });
    }


}//End Main