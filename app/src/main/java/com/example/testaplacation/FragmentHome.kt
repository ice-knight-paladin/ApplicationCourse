package com.example.testaplacation

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testaplacation.databinding.FragmentHomeBinding
import com.example.testaplacation.models.Course
import com.example.testaplacation.viewmodels.CoursesViewModel
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlin.system.exitProcess


@AndroidEntryPoint
class FragmentHome : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: CoursesViewModel by viewModels()
    private var coursesList = mutableListOf<Course>()

    @Inject
    lateinit var adapter: CourseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCourses()
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.recyclerCourses.adapter = adapter
        adapter.setIsLike(false)
        viewModel.users.observe(viewLifecycleOwner) {
            coursesList.addAll(it[0].courses)
            adapter.add(coursesList)
            adapter.notifyDataSetChanged()
        }

        binding.filter.setOnClickListener {
            adapter.sortCourses()
            if (adapter.getIsSort()) {
                binding.filterImage.background = resources.getDrawable(R.drawable.text_filter_up)
            } else {
                binding.filterImage.background = resources.getDrawable(R.drawable.text_filter_down)
            }
        }
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (shouldInterceptBackPress()) {
                showExitDialog()
            } else {
                isEnabled = false
                requireActivity().onBackPressed()
            }
        }
    }


    private fun shouldInterceptBackPress(): Boolean {
        return true
    }

    private fun showExitDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Выход")
            .setMessage("Вы уверены, что хотите выйти?")
            .setPositiveButton("Да") { _, _ ->
                exitProcess(0)
            }
            .setNegativeButton("Нет", null)
            .show()
    }
}
