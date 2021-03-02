package com.example.homework.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun initToolbar(toolbar: Toolbar, isDisplay: Boolean) {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(isDisplay)
                setHomeButtonEnabled(isDisplay)
            }
        }
    }
}