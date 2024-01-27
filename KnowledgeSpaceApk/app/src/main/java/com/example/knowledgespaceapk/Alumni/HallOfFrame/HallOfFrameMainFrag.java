package com.example.knowledgespaceapk.Alumni.HallOfFrame;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.Alumni.HallOfFrame.PreviousYrHoF.PreviousYrHoFMainScFrag;
import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class HallOfFrameMainFrag extends Fragment {

    private static final int  PICK_IMAGE = 301 ;
    private ArrayList<DataModelHallOfFrame> dataHolder;
    private AdapterViewFlipper adapterViewFlipper;
    private FloatingActionButton floatingBtnAddHoF;
    private RelativeLayout relativeLayContainerImgNNameVPopUpDialogAddHof;
    private Button viewAllAlumniTvHallOfFrameMainAct;

    //Dialog Box:
    private EditText totalNoOfAlumnisToEnterEditTvPopupAskAddHofNoOfAlumnisNYr;
    private TextView selectYearTvPopupAskAddHofNoOfAlumnisNYr;
    private Button proceedNxtBtnPopupAskAddHofNoOfAlumnisNYr;
    private ImageView cancelBtnPopupDialogAddHof;

    //Dialog Box Add Alumni Details:
    private TextView tvShowAlumniCountPopupDialogAddHof,yesBtnTvPopupSavingDataPopupDialog,NoTvPopupConfirmSavingData;
    private EditText editTvAlumniNamePopupDialogAddHof;
    private Button addNxtAlumniBtnPopupDialogAddHoF,finalAddAlumniBtnPopupDialogAddHof;
    private ImageView addAlumniImgVPopupDialogAddHof,cancelBtnPopupDialogFinalAddHof;
    private int currentCountOfAlumniHoF = 1;
    private Uri uri;
    private LinearLayout linearLayConfirmSavingDataPopupDialogAddHof;

    public HallOfFrameMainFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_hall_of_frame_main, container, false);
        adapterViewFlipper = view.findViewById(R.id.adapterViewFlipper);
        dataHolder = new ArrayList<>();
        addData();
        adapterViewFlipper.setAdapter(new HallOfFrameAdp(dataHolder));
        adapterViewFlipper.setFlipInterval(2600);
        adapterViewFlipper.setAutoStart(true);


        floatingBtnAddHoF = view.findViewById(R.id.floatingBtnAddHoF);
        floatingBtnAddHoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openPopUpAskAdmAddHof();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        viewAllAlumniTvHallOfFrameMainAct = view.findViewById(R.id.viewAllAlumniTvHallOfFrameMainAct);
        viewAllAlumniTvHallOfFrameMainAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_hallOfFrameMainFrag_to_previousYrHoFMainScFrag);
                }
        });

    }

    private void addData() {
        DataModelHallOfFrame card1 = new DataModelHallOfFrame(R.drawable.apple,"apple");
        dataHolder.add(card1);
        DataModelHallOfFrame card2 = new DataModelHallOfFrame(R.drawable.banana,"banana");
        dataHolder.add(card2);
        dataHolder.add(card1);
    }
}