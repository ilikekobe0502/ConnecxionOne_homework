package com.example.homework.ui.home

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework.PASS_NAME
import com.example.homework.ui.empty.EmptyFragment
import com.example.homework.ui.wallet.WalletFragment
import com.example.homework.withBundleValue

class HomePager2Adapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int) = when (position) {
        4 -> WalletFragment()
        else -> EmptyFragment().withBundleValue {
            putInt(PASS_NAME, position)
        }
    }
}