package com.example.testaplacation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testaplacation.api.ApiService
import com.example.testaplacation.models.CourseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {
    private var list = mutableListOf<CourseResponse>()
    private val _users = MutableLiveData<MutableList<CourseResponse>>()
    val users: LiveData<MutableList<CourseResponse>> = _users

    fun fetchCourses() {
        viewModelScope.launch {
            apiService.getCourses().enqueue(object : Callback<CourseResponse> {
                override fun onResponse(call: Call<CourseResponse>, response: Response<CourseResponse>) {
                    if (response.isSuccessful) {
                        list.add(response.body()!!)
                        _users.value = list
                    } else {

                    }
                }

                override fun onFailure(call: Call<CourseResponse>, t: Throwable) {

                }
            })
        }
    }
}