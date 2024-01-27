package com.example.adminapp.contactAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ContactAct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<dataModel> dataHolder;
    private SearchView searchView;
    private adapterRecV itemAdapter;
    private FloatingActionButton add_fab;
    private ImageView btnCancel;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        
        searchView = findViewById(R.id.searchVContact);
        recyclerView = findViewById(R.id.recyclerVContacts);

        add_fab = findViewById(R.id.add_fab);
        searchView.clearFocus();
        
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        dataModel = new ArrayList<>();
        
        getDataHolder();
        itemAdapter =  new adapterRecV(dataHolder);
        recyclerView.setAdapter(itemAdapter);
        search();
        addFabOnPress();
    }

    private void addFabOnPress() {
        add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ContactAct.this);
                dialog.setContentView(R.layout.custom_dialog_contact_add);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;


                btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
                saveBtn = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        dialog.setCancelable(true);
                    }
                });
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        dialog.setCancelable(true);
                        Toast.makeText(ContactAct.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

    }

    private void search() {
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
        ArrayList<dataModel> filteredList = new ArrayList<>();
        for(dataModel item : dataHolder){
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

    private void getDataHolder() {
        dataHolder = new ArrayList<>();
        //Add data to array-list "dataHolder"
        dataModel obj1 = new dataModel("Mrs.Repma Patel",
                "8985848687",R.drawable.apple);
        dataHolder.add(obj1);
        dataModel obj2 = new dataModel("Mrs.Subtoshi Pandey",
                "9897949596",R.drawable.apple);
        dataHolder.add(obj2);
        dataModel obj3 = new dataModel("Mr.Dablu Kochi",
                "5651545253",R.drawable.apple);
        dataHolder.add(obj3);
        dataModel obj4 = new dataModel("Mr.Girate Patel",
                "4845464241",R.drawable.apple);
        dataHolder.add(obj4);
        dataModel obj5 = new dataModel("Mrs. Joti Japan",
                "2326242521",R.drawable.apple);
        dataHolder.add(obj5);
        dataModel obj6 = new dataModel("Mrs.Yarisma Patel",
                "8985848687",R.drawable.apple);
        dataHolder.add(obj6);
        dataModel obj7 = new dataModel("Mrs.Rinku Hiesenberg",
                "8985848687",R.drawable.apple);
        dataHolder.add(obj7);
    }
}