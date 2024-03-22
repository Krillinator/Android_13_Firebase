package com.krillinator.lektion_13_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.krillinator.lektion_13_firebase.databinding.ActivityMainBinding
import com.krillinator.lektion_13_firebase.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var db : DatabaseReference
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toasts
        val toastSuccess = Toast.makeText(this, "Added User", Toast.LENGTH_SHORT)
        val toastFailure = Toast.makeText(this, "Added User", Toast.LENGTH_SHORT)

        // Components / Widgets
        val btnSubmitUser = binding.btnSubmitUser

        // Firebase
        db = FirebaseDatabase
            .getInstance("URL")
            .getReference("users")  // Category / Table

        // TODO - ID
        // TODO - Proper Table instead of calling in reference

        // Listeners
        btnSubmitUser.setOnClickListener {

            // val usersRef = FirebaseDatabase.getInstance().getReference("users")

            // TODO - Is there something you would like to know more about in the future?

            // TODO - Tasks
            // push().setValue == POST
            // db.child("ID") == GET
            // removeValue == DELETE
            // setValue == UPDATE

            db.push().setValue(
                User(
                    username = "Benny",
                    password = "321",
                    isEnabled = true,
                    isVerified = true
                )
            )
                .addOnSuccessListener { toastSuccess.show() }
                .addOnFailureListener { toastFailure.show() }
        }



    }
}