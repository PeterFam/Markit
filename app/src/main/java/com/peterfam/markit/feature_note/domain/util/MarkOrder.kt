package com.peterfam.markit.feature_note.domain.util

sealed class MarkOrder(val orderType: OrderType){

    class Title(orderType: OrderType): MarkOrder(orderType)

    class Date(orderType: OrderType): MarkOrder(orderType)

    class Color(orderType: OrderType): MarkOrder(orderType)
}
