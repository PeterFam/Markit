package com.peterfam.markit.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.peterfam.markit.ui.*


@Entity
data class Mark(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null,
){
    val markColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
}

class InvalidMarkException(msg: String): Exception(msg)
