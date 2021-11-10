package com.peterfam.markit.feature_note.presentation

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.util.MarkOrder

sealed class MarkItEvent {
    data class Order(val markOrder: MarkOrder): MarkItEvent()
    data class DeleteNote(val mark: Mark): MarkItEvent()
    object RestoreMark: MarkItEvent()
    object ToggleOrderSection: MarkItEvent()
}
