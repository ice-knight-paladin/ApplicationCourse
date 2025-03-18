package com.example.testaplacation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CourseModule {
    @Provides
    fun provideMessageAdapter(): CourseAdapter = CourseAdapter()
}