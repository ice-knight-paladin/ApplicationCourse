package com.example.testaplacation.api

import com.example.testaplacation.models.Course
import com.example.testaplacation.models.CourseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("u/0/uc?id=1BxT94DmvthLqTAK6Ezt_VcKFg1-e-U0L&export=download")
    fun getCourses(): Call<CourseResponse>
}