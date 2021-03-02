package com.example.homework.ui.empty

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework.PASS_NAME
import com.example.homework.base.BaseFragment
import com.example.homework.databinding.FragmentEmptyBinding
import com.example.homework.getBundleValue

class EmptyFragment : BaseFragment() {

    private val pageName by getBundleValue(PASS_NAME, -1)

    private var _binding: FragmentEmptyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmptyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            fragmentTitle.text = "Fragment -> $pageName"
        }
    }
}