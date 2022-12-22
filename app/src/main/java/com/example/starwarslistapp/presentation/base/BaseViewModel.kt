package com.example.starwarslistapp.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {
    val errorVisible = mutableStateOf(false)
    val error = mutableStateOf<Exception?>(null)

    fun showError(exception: Exception) {
        errorVisible.value = true
        error.value = exception
    }

    fun hideError() {
        errorVisible.value = false
        error.value = null
    }

    fun runAsync(isLoading: MutableState<Boolean>? = null, tryFunction: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Main) { isLoading?.value = true }
                tryFunction()
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) { showError(exception) }
            } finally {
                withContext(Dispatchers.Main) { isLoading?.value = false }
            }
        }
    }
}