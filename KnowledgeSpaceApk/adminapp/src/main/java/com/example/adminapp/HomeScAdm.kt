package com.example.adminapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.adminapp.AlumniActAdm.AlumniActMainScAdm
import com.example.adminapp.ApplicationActAdm.ApplicationActAdm
import com.example.adminapp.AttendanceAct.AttendanceAct
import com.example.adminapp.FeesActAdm.FeesActMainScAdm
import com.example.adminapp.GroupFragAdm.GroupFragAdm
import com.example.adminapp.HomeFragAdm.HomeFragAdm
import com.example.adminapp.HomeworkActAdm.HomeworkActAdm
import com.example.adminapp.MyPosts.MyPostActAdm
import com.example.adminapp.NotiFragAdm.NotiFragAdm
import com.example.adminapp.PlacementActAdm.PlacementMainActAdm
import com.example.adminapp.RewardsActAdm.RewardsActAdm
import com.example.adminapp.ScholarshipAct.ScholarshipActAdm
import com.example.adminapp.SettingsAct.settingAct
import com.example.adminapp.contactAct.ContactAct
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeScAdm // User Points Methods
    : AppCompatActivity() {
    private var drawerLayout: DrawerLayout? = null
    private var bottomNavigationView: BottomNavigationView? = null
    private var toolbar: Toolbar? = null
    private var navigationView: NavigationView? = null
    var uPoints = 0f
        private set
    var auth = FirebaseAuth.getInstance()
    var firebaseUser = auth.currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_sc_adm)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        toolbar = findViewById(R.id.appBar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        drawerLayout = findViewById(R.id.drawerNavigationDrawerLayoutAdmin)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout,
            toolbar, R.string.open, R.string.close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        //Testing -
        replaceFrag(HomeFragAdm())
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView?.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> replaceFrag(HomeFragAdm())
                R.id.group -> replaceFrag(GroupFragAdm())
                R.id.notification -> replaceFrag(NotiFragAdm())
            }
            true
        })
        setNavigationView()
    } //End OnCreate

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.custom_toolbar_menu_adm, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                drawerLayout!!.openDrawer(GravityCompat.START)
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFrag(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun setNavigationView() {
        navigationView = findViewById(R.id.drawerNavigationView)
        val headerView = navigationView?.getHeaderView(0)
        val linearLayDrawerNavHeaderAdm =
            headerView?.findViewById<LinearLayout>(R.id.linearLayDrawerNavHeaderAdm)
        linearLayDrawerNavHeaderAdm?.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext, RewardsActAdm::class.java
                )
            )
        }

        //Testing
        val tVDrawerNavHeader = headerView?.findViewById<TextView>(R.id.tVDrawerNavHeader)
        tVDrawerNavHeader?.text = auth.currentUser!!.email
        navigationView?.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.cv -> {}
                R.id.alumni -> {
                    startActivity(Intent(applicationContext, AlumniActMainScAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "alumni clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.application -> {
                    Toast.makeText(this@HomeScAdm, "Clicked", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, ApplicationActAdm::class.java))
                }

                R.id.hw -> {
                    startActivity(Intent(applicationContext, HomeworkActAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "hw clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.fees -> {
                    startActivity(Intent(applicationContext, FeesActMainScAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "fees clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.scholarship -> {
                    startActivity(Intent(applicationContext, ScholarshipActAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "scholarship clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.attendance ->                         //Toast.makeText(HomeScAdm.this, "attendance clicked", Toast.LENGTH_SHORT).show();
                    startActivity(Intent(applicationContext, AttendanceAct::class.java))

                R.id.routine ->                         //Toast.makeText(HomeScAdm.this, "routine clicked", Toast.LENGTH_SHORT).show();
                    startActivity(Intent(applicationContext, RoutineAct::class.java))

                R.id.placement -> {
                    startActivity(Intent(applicationContext, PlacementMainActAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "placement clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.contactList -> startActivity(
                    Intent(
                        applicationContext, ContactAct::class.java
                    )
                )

                R.id.examEnrollment -> Toast.makeText(
                    this@HomeScAdm,
                    "exams enrollment clicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.onlineExams -> Toast.makeText(
                    this@HomeScAdm,
                    "online exams clicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.posts -> {
                    startActivity(Intent(applicationContext, MyPostActAdm::class.java))
                    Toast.makeText(this@HomeScAdm, "posts demo clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.settings -> startActivity(
                    Intent(
                        applicationContext, settingAct::class.java
                    )
                )
            }
            false
        })
    }

    fun setuPoints(uPoints: Float) {
        this.uPoints = uPoints
    }
} //End Main
