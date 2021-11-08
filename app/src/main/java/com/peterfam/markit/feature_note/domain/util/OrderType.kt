package com.peterfam.markit.feature_note.domain.util

sealed class OrderType{
    object ASC: OrderType()
    object DESC : OrderType()
}
