package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// PUBLIC_INTERFACE
class ProfileViewModel : ViewModel() {
    /** Holds the user profile data. */
    var name by mutableStateOf("")
    var age by mutableStateOf("")
    var gender by mutableStateOf("")
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var goalWeight by mutableStateOf("")
    var activityLevel by mutableStateOf("")

    fun clear() {
        name = ""
        age = ""
        gender = ""
        height = ""
        weight = ""
        goalWeight = ""
        activityLevel = ""
    }
}
