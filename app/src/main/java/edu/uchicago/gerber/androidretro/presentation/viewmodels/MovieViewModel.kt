package edu.uchicago.gerber.androidretro.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {


    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES
    //////////////////////////////////////////
    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText


    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setQueryText(query: String) {
        _queryText.value = query
    }


    fun onSearch() {
        // TODO: search functionality to be implemented
    }
}
