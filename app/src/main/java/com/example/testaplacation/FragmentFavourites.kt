package com.example.testaplacation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.testaplacation.databinding.FragmentFavouritesBinding
import com.example.testaplacation.databinding.FragmentHomeBinding
import com.example.testaplacation.viewmodels.CoursesViewModel
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject


@AndroidEntryPoint
class FragmentFavourites : Fragment(R.layout.fragment_favourites) {

    private lateinit var binding: FragmentFavouritesBinding

    private val viewModel: CoursesViewModel by viewModels()

    @Inject
    lateinit var adapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCourses()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
        binding.recyclerCourses.adapter = adapter
        adapter.setIsFavo(true)

        viewModel.users.observe(viewLifecycleOwner) {
            for (i in it[0].courses){
                adapter.add(i)
            }

            //Log.d("adwddqwd", "${adapter.itemCount}")
            adapter.notifyDataSetChanged()
        }
    }

}