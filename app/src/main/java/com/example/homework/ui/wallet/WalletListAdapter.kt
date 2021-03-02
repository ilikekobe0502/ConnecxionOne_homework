package com.example.homework.ui.wallet

import android.annotation.SuppressLint
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.homework.R
import com.example.homework.base.BaseMultiItemQuickAdapter
import com.example.homework.data.entity.ItemEntity
import com.example.homework.databinding.ViewItemAdBinding
import com.example.homework.databinding.ViewItemCardViewCoinBinding
import com.example.homework.loadUrl

class WalletListAdapter : BaseMultiItemQuickAdapter<ItemEntity>() {

    init {
        addItemType(ItemEntity.ITEM_1, R.layout.view_item_card_view_coin)
        addItemType(ItemEntity.ITEM_2, R.layout.view_item_ad)
    }

    @SuppressLint("SetTextI18n")
    override fun convert(holder: BaseViewHolder, item: ItemEntity) {
        when (holder.itemViewType) {
            ItemEntity.ITEM_1 -> {
                with(ViewItemCardViewCoinBinding.bind(holder.itemView)) {
                    icon.loadUrl("https://i.pinimg.com/originals/44/94/a6/4494a6c3c1a0812144d40e3106c0c5cc.png")
                    coinName.text = "容幣_${holder.layoutPosition}"
                }
            }

            ItemEntity.ITEM_2 -> {
                with(ViewItemAdBinding.bind(holder.itemView)) {
                    icon.background = (ContextCompat.getDrawable(icon.context,R.mipmap.ic_launcher))
                }
            }
        }
    }
}