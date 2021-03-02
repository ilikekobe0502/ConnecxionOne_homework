package com.example.homework.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.base.BaseFragment
import com.example.homework.data.entity.ItemEntity
import com.example.homework.databinding.FragmentWalletListBinding

class WalletListFragment : BaseFragment() {

    private var _binding: FragmentWalletListBinding? = null
    private val binding get() = _binding!!

    private val adapter: WalletListAdapter by lazy { WalletListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = this@WalletListFragment.adapter
            }

            val list = mutableListOf<ItemEntity>()
            list.add(ItemEntity(ItemEntity.ITEM_2, Any()))

            for (index in 0 until 25) {
                list.add(ItemEntity(ItemEntity.ITEM_1, Any()))
            }
            adapter.setNewInstance(list)
        }
    }
}