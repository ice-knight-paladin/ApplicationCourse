package com.example.testaplacation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testaplacation.databinding.FragmentHomeBinding
import com.example.testaplacation.viewmodels.CoursesViewModel
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import okhttp3.internal.notify


@AndroidEntryPoint
class FragmentHome : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: CoursesViewModel by viewModels()

    @Inject
    lateinit var adapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCourses()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.recyclerCourses.adapter = adapter
        adapter.setIsFavo(false)

        viewModel.users.observe(viewLifecycleOwner) {
            adapter.add(it[0].courses)
            //Log.d("adwddqwd", "${adapter.itemCount}")
            adapter.notifyDataSetChanged()
        }
        Log.d("qfrqwffwefg", "${viewModel.users.value}")

        binding.filter.setOnClickListener{
            adapter.sortCourses()
        }

    }

}