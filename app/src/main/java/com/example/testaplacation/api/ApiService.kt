package com.example.testaplacation.api

import com.example.testaplacation.models.Course
import com.example.testaplacation.models.CourseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    fun getCourses(): Call<CourseResponse>
}