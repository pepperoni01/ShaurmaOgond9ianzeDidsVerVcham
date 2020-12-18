package com.example.shaurmaogond9larianzedidsvervcham

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        mail = findViewById(R.id.Email)
        pass = findViewById(R.id.Password)
        submit = findViewById(R.id.Submit)
        submit.setOnClickListener {
            val usermail = mail.text.toString()
            val userpass = pass.text.toString()
            if(usermail.isEmpty()||userpass.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ მეშაურმეს მეილი და პაროლი!", Toast.LENGTH_LONG).show()

            }else{
                mAuth.createUserWithEmailAndPassword(usermail, userpass).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "მეშაურმე დამატებულია", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_LONG ).show()
                    }
                }
            }
        }
    }

}