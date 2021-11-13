package com.peterfam.markit.feature_note.presentation.marks_list_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.peterfam.markit.feature_note.domain.util.MarkOrder
import com.peterfam.markit.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier,
    markOrder: MarkOrder = MarkOrder.Date(OrderType.DESC),
    onOrderChanged : (MarkOrder) -> Unit
){
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Title",
                selected = markOrder is MarkOrder.Title,
                onSelected = { onOrderChanged(MarkOrder.Title(markOrder.orderType))},
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = markOrder is MarkOrder.Title,
                onSelected = { onOrderChanged(MarkOrder.Date(markOrder.orderType))},
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = markOrder is MarkOrder.Title,
                onSelected = { onOrderChanged(MarkOrder.Color(markOrder.orderType))},
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Ascending",
                selected = markOrder.orderType is OrderType.ASC,
                onSelected = { onOrderChanged(markOrder.copy(OrderType.ASC))},
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = markOrder.orderType is OrderType.DESC,
                onSelected = {  onOrderChanged(markOrder.copy(OrderType.DESC))},
            )
        }

    }
}