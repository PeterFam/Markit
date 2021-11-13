package com.peterfam.markit.feature_note.domain.util

sealed class MarkOrder(val orderType: OrderType){

    class Title(orderType: OrderType): MarkOrder(orderType)

    class Date(orderType: OrderType): MarkOrder(orderType)

    class Color(orderType: OrderType): MarkOrder(orderType)

    fun copy(orderType: OrderType): MarkOrder{
         return when(this){
             is Title -> Title(orderType)
             is Date -> Date(orderType)
             is Color -> Color(orderType)
         }
    }
}
