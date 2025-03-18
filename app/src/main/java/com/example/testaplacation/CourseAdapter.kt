package com.example.testaplacation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testaplacation.databinding.ItemCourseBinding
import com.example.testaplacation.models.Course
import java.text.SimpleDateFormat

class CourseAdapter : RecyclerView.Adapter<CourseViewHolder>() {

    private var listCourses = mutableListOf<Course>()
    private var isFavo = false
    private var isSort = true

    fun setIsFavo(a: Boolean) {
        isFavo = a
    }

    fun sortCourses() {
        if (isSort) {
            listCourses.sortBy { SimpleDateFormat("yyyy-MM-dd").parse(it.startDate) }
            isSort = false
        } else {//В обратном порядке
            listCourses.sortByDescending { SimpleDateFormat("yyyy-MM-dd").parse(it.startDate) }
            isSort = true
        }
        Log.d("sdadasd", "$listCourses")
        notifyDataSetChanged()
    }

    fun add(course: Course) {
        if (isFavo) {
            if (course.hasLike) {
                listCourses.add(course)
            }
        } else {
            listCourses.add(course)
        }
    }


    fun add(course: List<Course>) {
        listCourses.addAll(course)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            ItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listCourses.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        with(holder.binding) {
            textDate.text = course.startDate
            nameCourse.text = course.title
            courseDescription.text = course.text
            coursePrice.text = "${course.price} ₽"
            courseRate.text = course.rate
            if (course.hasLike) {
                hasLike.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.ic_favo_green,
                    0,
                    0,
                    0
                )
            }
            image.setImageResource(R.drawable.img)
        }
    }

}

class CourseViewHolder(val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root) {

}
