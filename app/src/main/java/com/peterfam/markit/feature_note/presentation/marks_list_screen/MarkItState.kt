package com.peterfam.markit.feature_note.presentation.marks_list_screen

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.util.MarkOrder
import com.peterfam.markit.feature_note.domain.util.OrderType

data class MarkItState (
    val marks: List<Mark> = emptyList(),
    val marksOrder: MarkOrder = MarkOrder.Date(OrderType.DESC),
    val isOrderSectionVisible: Boolean = false)
