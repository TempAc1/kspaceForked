package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FeesHistoryAct extends AppCompatActivity {

    private RecyclerView recyclerVFeesHistory;
    private adapterRecVFeesHistoryAct adapter;
    private ArrayList<dataModelRecVFeesHistory> userDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_history);

        recyclerVFeesHistory= findViewById(R.id.recyclerVFeesHistoryAct);
        recyclerVFeesHistory.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapterRecVFeesHistoryAct(userDataList);
        recyclerVFeesHistory.setAdapter(adapter);


        dataInit();

    }//End onCreate

//    private String setTransactionImgV(dataModelRecVFeesHistory obj) {
//        if(obj.getTransStatusFeesHistTV().equals("Success")){
//            String success = obj.setTransactionStatusImgV(R.drawable.success_tick);
//        }else{
//            obj.setTransactionStatusImgV(R.drawable.wrong_cross);
//        }
//        return
    // just checking
//    }

    private void dataInit() {
        dataModelRecVFeesHistory obj1 = new dataModelRecVFeesHistory(R.drawable.success_tick,"Academics","120000",
                "Success","#8564");
//        obj1.getTransStatusFeesHistTV();
//        setTransactionImgV();
        userDataList.add(obj1);
        dataModelRecVFeesHistory obj2 = new dataModelRecVFeesHistory(R.drawable.success_tick,"Academics","120000",
                "Success","#8564");
        userDataList.add(obj2);
        dataModelRecVFeesHistory obj3 = new dataModelRecVFeesHistory(R.drawable.success_tick,"Academics","120000",
                "Success","#8564");
        userDataList.add(obj3);
        dataModelRecVFeesHistory obj4 = new dataModelRecVFeesHistory(R.drawable.success_tick,"Academics","120000",
                "Success","#8564");
        userDataList.add(obj4);
        dataModelRecVFeesHistory obj5 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj5);
        dataModelRecVFeesHistory obj6 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj6);
        dataModelRecVFeesHistory obj7 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj7);
        dataModelRecVFeesHistory obj8 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj8);
        dataModelRecVFeesHistory obj9 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj9);
        dataModelRecVFeesHistory obj10 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj10);
        dataModelRecVFeesHistory obj11 = new dataModelRecVFeesHistory("Academics","120000",
                "Success","#8564");
        userDataList.add(obj11);









    }
}//End Main