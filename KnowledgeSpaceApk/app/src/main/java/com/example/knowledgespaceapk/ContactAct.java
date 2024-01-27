package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactAct extends AppCompatActivity {

    private RecyclerView recyclerViewContactAct;
    private ArrayList<dataModelRecVContactAct> dataHolderContactActs;
    private SearchView searchView;
    private adapterRecVContact itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        searchView = findViewById(R.id.searchVContact);
        searchView.clearFocus();
        recyclerViewContactAct = findViewById(R.id.recyclerVContacts);

        recyclerViewContactAct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataHolderContactActs = new ArrayList<>();

        //Add data to array-list "dataHolderContactActs"
        dataModelRecVContactAct obj1 = new dataModelRecVContactAct("Mrs.Repma Patel",
                "8985848687",R.drawable.apple);
        dataHolderContactActs.add(obj1);
        dataModelRecVContactAct obj2 = new dataModelRecVContactAct("Mrs.Subtoshi Pandey",
                "9897949596",R.drawable.apple);
        dataHolderContactActs.add(obj2);
        dataModelRecVContactAct obj3 = new dataModelRecVContactAct("Mr.Dablu Kochi",
                "5651545253",R.drawable.apple);
        dataHolderContactActs.add(obj3);
        dataModelRecVContactAct obj4 = new dataModelRecVContactAct("Mr.Girate Patel",
                "4845464241",R.drawable.apple);
        dataHolderContactActs.add(obj4);
        dataModelRecVContactAct obj5 = new dataModelRecVContactAct("Mrs. Joti Japan",
                "2326242521",R.drawable.apple);
        dataHolderContactActs.add(obj5);
        dataModelRecVContactAct obj6 = new dataModelRecVContactAct("Mrs.Yarisma Patel",
                "8985848687",R.drawable.apple);
        dataHolderContactActs.add(obj6);
        dataModelRecVContactAct obj7 = new dataModelRecVContactAct("Mrs.Rinku Hiesenberg",
                "8985848687",R.drawable.apple);
        dataHolderContactActs.add(obj7);

        itemAdapter = new adapterRecVContact(dataHolderContactActs);
        recyclerViewContactAct.setAdapter(itemAdapter);
        searchV();
    }//End OnCreate

    private void searchV(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<dataModelRecVContactAct> filteredList = new ArrayList<>();
        for(dataModelRecVContactAct item : dataHolderContactActs){
            if(item.getContactName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found ☹", Toast.LENGTH_SHORT).show();
        }else{
            itemAdapter.setFilteredList(filteredList);
        }
    }
}//End Main