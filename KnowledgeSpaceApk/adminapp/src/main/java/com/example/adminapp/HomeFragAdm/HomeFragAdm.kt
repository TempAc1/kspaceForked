package com.example.adminapp.HomeFragAdm

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.SearchManager
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.example.adminapp.databinding.FragmentHomeFragAdmBinding
import com.example.adminapp.mvc_posts_collections.controllerPostCollections
import com.example.adminapp.mvc_posts_collections.controllerPostCollections.FetchPostsCallback
import com.example.adminapp.mvc_posts_collections.dataModelPostCollection
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HomeFragAdm : Fragment() {
    private val recyclerVFragHomeSc: RecyclerView? = null
    var adapter: adapterRecVHomeFAdmDemo? = null
    var toolbar: Toolbar? = null
    private var menuItem: MenuItem? = null
    private var searchView: SearchView? = null
    private val dataHolder: ArrayList<dataModelPostCollection>? = null
    private val commentImgVSingleRDesRecHomeF: ImageView? = null
    private var btnCancel: ImageView? = null
    private val floatingActionBtnHomeFragAdm: FloatingActionButton? = null
    private val createPostFloatingActBtnHomeFragAdm: FloatingActionButton? = null
    private val createEventFloatingActBtnHomeFragAdm: FloatingActionButton? = null
    private var postBtnCreatePostHomeFrag: Button? = null
    private var postBtnCreateEventHomeFragAdm: Button? = null
    private var attachmentTvHomeFAdm: TextView? = null
    private var startDateTvCreateEventDialogAdm: TextView? = null
    private var endDateTvCreateEventDialogAdm: TextView? = null
    private var startTimeTvCreateEventDialogAdm: TextView? = null
    private var endTimeTvCreateEventDialogAdm: TextView? = null
    private var venueTvCreateEventHomeFAdm: TextView? = null
    private var isFabBtnVisible = false
    private var startDateTvClicked = false
    private var endDateTvClicked = false
    private var startTimeClicked = false
    private var endTimeClicked = false
    private var Hour = 0
    private var Minute = 0

    //    private String uEndDate,uStartDate,
    private var uStartDate: String? = null
    private var uEndDate: String? = null
    private var uStartTime: String? = null
    private var uEndTime: String? = null
    private var endDateObj: Date? = null
    private var startDateObj: Date? = null
    val myCal = Calendar.getInstance()
    private var viewModel: ViewModel? = null
    private var binding: FragmentHomeFragAdmBinding? = null
    private val db: FirebaseFirestore? = null
    private var controllerPostCollections: controllerPostCollections? = null
    var auth = FirebaseAuth.getInstance()
    var user = auth.currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = FragmentHomeFragAdmBinding.inflate(inflater, container, false)


//        recyclerVFragHomeSc.setLayoutManager(new LinearLayoutManager(getContext()));
//        dataHolder=new ArrayList<>();

//        dataModelRecVHomeFragAdm obj1 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj1);
//        dataModelRecVHomeFragAdm obj2 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj2);
//        dataModelRecVHomeFragAdm obj3 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj3);
//        dataModelRecVHomeFragAdm obj4 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj4);
//        dataModelRecVHomeFragAdm obj5 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj5);
//        recyclerVFragHomeSc.setAdapter(new adapterRecVHomeFragAdm(dataHolder));
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelHomeFragAdmDemo::class.java)
        floatingBtnClicked()

//        commentImgVSingleRDesRecHomeF = view.findViewById(R.id.commentBtnHomeFragAdm);
//        floatingActionBtnHomeFragAdm = view.findViewById(R.id.floatingActionBtnHomeFragAdm);
//        createPostFloatingActBtnHomeFragAdm = view.findViewById(R.id.createPostFloatingActBtnHomeFragAdm);
//        createEventFloatingActBtnHomeFragAdm = view.findViewById(R.id.createEventFloatingActBtnHomeFragAdm);
        val cUser = auth.currentUser!!.email
        val dateTimeStamp = Timestamp(Date()).toString()
        controllerPostCollections = controllerPostCollections()


        //Sendig post to DB
//        if(!cUser.matches("")) {
//
//            dataModelPostCollection dataModelPostCollection = new dataModelPostCollection("postTitle", "This is a post for testing purposes", "https://api.slingacademy.com/public/sample-photos/1.jpeg", dateTimeStamp, cUser, "dypcoe#0841AKMHIN");
//
//            controllerPostCollections.addPost(dataModelPostCollection);
//
//            Toast.makeText(getContext(), "post added", Toast.LENGTH_SHORT).show();
//            Log.i("dataModel", dataModelPostCollection.toString());
//
//
//
//        }

//        recyclerVFragHomeSc =  view.findViewById(R.id.RecyclerVHomeFragAdm);
        binding!!.recyclerVHomeFragAdm.layoutManager = LinearLayoutManager(context)
        adapter = adapterRecVHomeFAdmDemo(dataHolder)
        recyclerVFragHomeSc?.adapter = adapter


        //Getting post from db
        controllerPostCollections!!.getPosts(object : FetchPostsCallback {
            override fun onPostsFetched(postList: List<dataModelPostCollection>?) {
                adapter?.updatePosts(postList)
            }

            override fun onFetchPostsFailure(e: Exception?) {}
        })


        //Updating post from DB
        //Testing
        // Initialize Firestore
//        db = FirebaseFirestore.getInstance();
//
//        String postId = "ahvdEkeqBcyNR6gzkSc8";
//
//        // Get a reference to the post document
//        DocumentReference postRef = db.collection("Posts").document(postId);
//
//        // Create a map with the new post data
//        Map<String, Object> newPost = new HashMap<>();
//        newPost.put("title", "New Post Title");
//        newPost.put("content", "New post content.");
//
//        postRef.update(newPost)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            // Post updated successfully
//                            Toast.makeText(getContext(), "Post updated", Toast.LENGTH_SHORT).show();
//                        } else {
//                            // Handle the error
//                            Toast.makeText(getContext(), "Post update Error", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }

    private fun floatingBtnClicked() {
        floatingActionBtnHomeFragAdm?.setOnClickListener { //TODO Button Animatation lagana hai
            if (!isFabBtnVisible) {
                createPostFloatingActBtnHomeFragAdm!!.visibility = View.VISIBLE
                createEventFloatingActBtnHomeFragAdm!!.visibility = View.VISIBLE
                isFabBtnVisible = true
            } else {
                createPostFloatingActBtnHomeFragAdm!!.visibility = View.GONE
                createEventFloatingActBtnHomeFragAdm!!.visibility = View.GONE
                isFabBtnVisible = false
            }
        }
        createPostFloatingActBtnHomeFragAdm?.setOnClickListener {
            val dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.custom_dialog_homef_createpost)
            dialog.window!!
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.attributes.windowAnimations = R.style.animation

            //Code for attachement textv
            attachmentTvHomeFAdm =
                dialog.findViewById<View>(R.id.courseNameTvAddModuleCourseSelectedF) as TextView

            //Code for Dialog Cancel Btn
            btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
            postBtnCreatePostHomeFrag = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
            btnCancel?.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
                dialog.setCancelable(true)
            })
            postBtnCreatePostHomeFrag?.setOnClickListener(View.OnClickListener {
                dialog.setCancelable(true)
                dialog.dismiss()
                Toast.makeText(activity, "Posting...", Toast.LENGTH_SHORT).show()
            })
            attachmentTvHomeFAdm?.setOnClickListener {
                val PICKFILE_RESULT_CODE = 1
                val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
                acessFilesIntent.setType("*/*")
                startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
            }
            dialog.show()
        }
        createEventFloatingActBtnHomeFragAdm?.setOnClickListener {
            openDialog()
            checkDNT()
        }
    } //End postMethod

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                attachmentTvHomeFAdm!!.text = filePath
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.custom_toolbar_menu_adm, menu)
        menuItem = menu.findItem(R.id.search_button)
        searchView = menuItem?.getActionView() as SearchView?
        val searchManager = requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView!!.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                //mysearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if(adapter != null){
//                    adapter.getFilter().filter(newText);
//                }else{
//                    Toast.makeText(getContext(), "invalid search", Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun openDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.create_event_dialog_homef_adm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation
        attachmentTvHomeFAdm =
            dialog.findViewById<View>(R.id.courseNameTvAddModuleCourseSelectedF) as TextView
        startDateTvCreateEventDialogAdm = dialog.findViewById(R.id.startDateTvCreateEventDialogAdm)
        endDateTvCreateEventDialogAdm = dialog.findViewById(R.id.endDateTvCreateEventDialogAdm)
        startTimeTvCreateEventDialogAdm = dialog.findViewById(R.id.startTimeTvCreateEventDialogAdm)
        endTimeTvCreateEventDialogAdm = dialog.findViewById(R.id.endTimeTvCreateEventDialogAdm)
        venueTvCreateEventHomeFAdm = dialog.findViewById(R.id.venueTvCreateEventHomeFAdm)
        postBtnCreateEventHomeFragAdm = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)

        //CODE FOR DIALOG BUTTONS
        btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        postBtnCreatePostHomeFrag = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
        btnCancel?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
        })

        postBtnCreateEventHomeFragAdm?.setOnClickListener(View.OnClickListener { postBtnCreateEventClicked() })
        attachmentTvHomeFAdm!!.setOnClickListener {
            val PICKFILE_RESULT_CODE = 1
            val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
            acessFilesIntent.setType("*/*")
            startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
        }
        dialog.show()
    }

    private fun postBtnCreateEventClicked() {
        //TODO : sendDataTOApi() & Toast sahi krna hai
        validateNverify()
    }

    private fun checkDNT() {
        //START DATE PICKER
        val startDateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                myCal[Calendar.YEAR] = year
                myCal[Calendar.MONTH] = month
                myCal[Calendar.DAY_OF_MONTH] = day
                UpdateStartDateLabel()
            }

        //END DATE PICKER
        val endDateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                myCal[Calendar.YEAR] = year
                myCal[Calendar.MONTH] = month
                myCal[Calendar.DAY_OF_MONTH] = day
                UpdateEndDateLabel()
            }
        startDateTvCreateEventDialogAdm!!.setOnClickListener { view ->
            startDateTvClicked = true
            DatePickerDialog(
                view.context,
                startDateSetListener,
                myCal[Calendar.YEAR],
                myCal[Calendar.MONTH],
                myCal[Calendar.DAY_OF_MONTH]
            ).show()
        }
        endDateTvCreateEventDialogAdm!!.setOnClickListener { view ->
            endDateTvClicked = true
            DatePickerDialog(
                view.context,
                endDateSetListener,
                myCal[Calendar.YEAR],
                myCal[Calendar.MONTH],
                myCal[Calendar.DAY_OF_MONTH]
            ).show()
        }
        startTimeTvCreateEventDialogAdm!!.setOnClickListener {
            startTimeClicked = true
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    val AM_PM: String
                    Hour = selectedHour
                    Minute = selectedMinute
                    AM_PM = if (selectedHour < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    //Set text
                    startTimeTvCreateEventDialogAdm!!.text = "$selectedHour:$selectedMinute $AM_PM"
                    uStartTime = startTimeTvCreateEventDialogAdm!!.text.toString()
                }
            val timePickerDialog = TimePickerDialog(context, onTimeSetListener, Hour, Minute, false)
            timePickerDialog.setTitle("Select Time")
            timePickerDialog.show()
        }
        endTimeTvCreateEventDialogAdm!!.setOnClickListener {
            endTimeClicked = true
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    val AM_PM: String
                    Hour = selectedHour
                    Minute = selectedMinute
                    AM_PM = if (selectedHour < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    //Set Text
                    endTimeTvCreateEventDialogAdm!!.text = "$selectedHour:$selectedMinute $AM_PM"
                    uEndTime = endTimeTvCreateEventDialogAdm!!.text.toString()
                }
            val timePickerDialog = TimePickerDialog(context, onTimeSetListener, Hour, Minute, false)
            timePickerDialog.setTitle("Select Time")
            timePickerDialog.show()
        }
        venueTvCreateEventHomeFAdm!!.setOnClickListener {
            //TODO
        }
    }

    private fun UpdateStartDateLabel() {
        val myFormat = "dd/MM/yy"
        val DateFormat = SimpleDateFormat(myFormat)
        uStartDate = DateFormat.format(myCal.time)
        try {
            startDateObj = SimpleDateFormat("dd/MM/yyyy").parse(uStartDate)
        } catch (e: Exception) {
            Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
        }
        startDateTvCreateEventDialogAdm!!.text = uStartDate
    }

    private fun UpdateEndDateLabel() {
        val myFormat = "dd/MM/yy"
        val endDateFormat = SimpleDateFormat(myFormat, Locale.US)
        uEndDate = endDateFormat.format(myCal.time)
        endDateTvCreateEventDialogAdm!!.text = uEndDate
        try {
            endDateObj = SimpleDateFormat("dd/MM/yyyy").parse(uEndDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    private fun validateNverify() {
        //check click hua h date n time par
        if (startDateTvClicked && endDateTvClicked && startTimeClicked && endTimeClicked) {
            //tv are clicked atleast
            if (uStartDate == uEndDate && uStartTime == uEndTime) {
                //start n end date same dala hai n time diff h
                Toast.makeText(
                    context,
                    "Since Dates r equal Time cannot be same",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (uStartDate == uEndDate && uStartTime != uEndTime) {
                Toast.makeText(context, "2nd executed", Toast.LENGTH_SHORT).show()
            } else if (startDateObj!!.compareTo(endDateObj) < 0) {
                //agar start date chota h end se to time se kya hi mtlb
                Toast.makeText(
                    context,
                    "start date less than end ok ideal case",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (startDateObj!!.compareTo(endDateObj) > 0) {
                //mtlb start date bara h end se OR YEH ALLOW NAHI HAI
                Toast.makeText(context, "start great then last no valid", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Last else part executed", Toast.LENGTH_SHORT).show()
        }
    }
}