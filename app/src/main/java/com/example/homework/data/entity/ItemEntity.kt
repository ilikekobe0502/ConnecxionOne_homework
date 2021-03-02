package com.example.homework.data.entity

import androidx.annotation.IntDef
import com.example.homework.base.BaseEntity

class ItemEntity(
    @ItemType type: Int,
    var bean: Any
) : BaseEntity() {

    init {
        mItemType = type
    }

    companion object {
        const val ITEM_1 = 2
        const val ITEM_2 = 1
    }

    @IntDef(ITEM_1, ITEM_2)
    @Retention(AnnotationRetention.SOURCE)
    annotation class ItemType
}