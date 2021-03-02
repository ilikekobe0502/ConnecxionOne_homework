package com.example.homework.ui.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.R
import com.example.homework.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.LabelVisibilityMode

class HomeActivity : AppCompatActivity() {

    private val adapter by lazy { HomePager2Adapter(this) }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        with(binding) {
            viewPager2.apply {
                isUserInputEnabled = false
                offscreenPageLimit = this@HomeActivity.adapter.itemCount
                adapter = this@HomeActivity.adapter
            }

            bottomNavView.menu.apply {
                clear()
                add(Menu.NONE, R.id.home_call, 0, R.string.phone).setIcon(R.drawable.ic_outline_phone_24)
                add(Menu.NONE, R.id.home_chat, 1, R.string.chat).setIcon(R.drawable.ic_outline_chat_24)
                add(Menu.NONE, R.id.home_scanner, 2, R.string.scan).setIcon(R.drawable.ic_outline_qr_code_scanner_24)
                add(Menu.NONE, R.id.home_explore, 3, R.string.explore).setIcon(R.drawable.ic_outline_menu_book_24)
                add(Menu.NONE, R.id.home_wallet, 4, R.string.wallet).setIcon(R.drawable.ic_outline_account_balance_wallet_24)
            }

            bottomNavView.apply {
                labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

                setOnNavigationItemSelectedListener { item ->
                    viewPager2.setCurrentItem(item.order, false)
                    return@setOnNavigationItemSelectedListener true
                }
                selectedItemId = R.id.home_wallet
                viewPager2.setCurrentItem(4, false)
            }
        }
    }
}