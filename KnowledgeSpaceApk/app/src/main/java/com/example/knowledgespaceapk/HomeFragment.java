package com.example.knowledgespaceapk;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerVFragHomeSc;
    adapterRecVHomeFrag adapter;
    Toolbar toolbar;
    private MenuItem menuItem;
    private SearchView searchView;
    private ArrayList<dataModelRecVFragHome> dataHolder;
    private ImageView commentImgVSingleRDesRecHomeF;


    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.custom_toolbar_menu,menu);
        menuItem = menu.findItem(R.id.search_button);

        searchView = (SearchView)menuItem.getActionView();

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //mysearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(adapter != null){
                    adapter.getFilter().filter(newText);
                }else{
                    Toast.makeText(getContext(), "invalid search", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

   // private void mysearch(String query) { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,container,false);
        recyclerVFragHomeSc =  view.findViewById(R.id.recyclerVFragHomeSc);
        commentImgVSingleRDesRecHomeF = view.findViewById(R.id.commentImgVSingleRDesRecHomeF);
        recyclerVFragHomeSc.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder=new ArrayList<>();

        dataModelRecVFragHome obj1 = new dataModelRecVFragHome(R.drawable.fest,"Techno-fest 2k23","Presenting " +
                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
        dataHolder.add(obj1);
        dataModelRecVFragHome obj2 = new dataModelRecVFragHome(R.drawable.fest,"Techno-fest 2k23","Presenting " +
                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
        dataHolder.add(obj2);
        dataModelRecVFragHome obj3 = new dataModelRecVFragHome(R.drawable.fest,"Techno-fest 2k23","Presenting " +
                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
        dataHolder.add(obj3);
        dataModelRecVFragHome obj4 = new dataModelRecVFragHome(R.drawable.fest,"Techno-fest 2k23","Presenting " +
                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
        dataHolder.add(obj4);
        dataModelRecVFragHome obj5 = new dataModelRecVFragHome(R.drawable.fest,"Techno-fest 2k23","Presenting " +
                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
        dataHolder.add(obj5);
        recyclerVFragHomeSc.setAdapter(new adapterRecVHomeFrag(dataHolder));

        return view;
    }//End OnCreateView


}//End Fragment