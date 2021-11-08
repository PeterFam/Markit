package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository
import com.peterfam.markit.feature_note.domain.util.MarkOrder
import com.peterfam.markit.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMarksUseCase (private val repository: MarkItRepository){
    operator fun invoke(markOrder: MarkOrder = MarkOrder.Date(OrderType.DESC)
    ) : Flow<List<Mark>>{
       return repository.getMarks().map { marks ->
           when(markOrder.orderType){
               is OrderType.ASC -> {
                   when(markOrder){
                       is MarkOrder.Title -> marks.sortedBy { it.title.lowercase() }
                       is MarkOrder.Date -> marks.sortedBy { it.timestamp }
                       is MarkOrder.Color -> marks.sortedBy { it.color }
                   }
               }
               is OrderType.DESC -> {
                   when(markOrder){
                       is MarkOrder.Title -> marks.sortedByDescending { it.title.lowercase() }
                       is MarkOrder.Date -> marks.sortedByDescending { it.timestamp }
                       is MarkOrder.Color -> marks.sortedByDescending { it.color }
                   }
               }
           }
       }
    }
}