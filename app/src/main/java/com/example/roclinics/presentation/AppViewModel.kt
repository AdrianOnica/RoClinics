package com.example.roclinics.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.roclinics.data.UserData
import com.example.roclinics.presentation.common.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val db: FirebaseFirestore
) : ViewModel() {

    val signedIn = mutableStateOf(false)
    val completeInformation = mutableStateOf(false)
    val userDataState = mutableStateOf<UserData?>(null)


    init {

//        auth.signOut()
           val currentUid = auth.currentUser
//        val currentPhoneNumber = auth.currentUser?.phoneNumber
//        completeInformation.value = currentPhoneNumber != null
        signedIn.value = currentUid != null
        Log.d("Profile", ": current signin ${signedIn.value} ")

        Log.d("Profile", ": current uid ${currentUid?.uid} ")
//            currentUid?.uid?.let {
//                getData(it)
//            }

    }
    fun onSignUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Profile", "onSignUp: you signedup with succes ")
                    signedIn.value = true
                }
            }
    }

    fun createOrUpdateProfile(
        firstName: String? = null,
        lastName: String? = null,
        phoneNumber: String? = null,
        email: String? = null,
        city: String? = null,
        town: String? = null,
    ) {
        val uid = auth.currentUser?.uid
        val userData = UserData(
            userId = uid,
            firstName = firstName ?: userDataState.value?.firstName,
            lastName = lastName ?: userDataState.value?.lastName,
            phoneNumber = phoneNumber ?: userDataState.value?.phoneNumber,
            email = email ?: userDataState.value?.email,
            city = city ?: userDataState.value?.city,
            town = town ?: userDataState.value?.town,
        )
        uid?.let {
            db.collection(Constants.USERS).document(it).get().addOnSuccessListener { document ->
                if (document.exists()) {
                    document.reference.update(userData.toMap()).addOnSuccessListener {
                        Log.d("Profile", "createProfile: update succesfully ")
                        userDataState.value = userData
                    }.addOnFailureListener {
                        Log.d("Profile", "createProfile: update failed ")

                    }
                } else {
                    db.collection(Constants.USERS).document(it).set(userData).addOnSuccessListener {
                        getData(uid)
                        Log.d("Profile", "createProfile: created with succes ")
                        Log.d("Profile", "createProfile: $uid ")
                    }.addOnFailureListener {
                        Log.d("Profile", "createProfile: creation failed ")
                    }
                }
            }
        }
    }

    fun getData(uid:String){
        db.collection(Constants.USERS).document(uid).get().addOnSuccessListener {
            val user = it.toObject<UserData>()
            userDataState.value = user
            Log.d("Profile", "getData: Data retrieved succesfully")

        }.addOnFailureListener {
            Log.d("Profile", "getData: Data retrieved unsuccesfully")
        }
    }


    fun onSignIn(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Profile", "onSignIn: Logged in succesfully ")
                signedIn.value = true
                Log.d("Profile", "onSignIn: sign in value after login ${signedIn.value}")

            } else {
                Log.d("Profile", "onSignIn: Unsuccesfull login")

            }

        }
    }
}
// TODO signup bug
//