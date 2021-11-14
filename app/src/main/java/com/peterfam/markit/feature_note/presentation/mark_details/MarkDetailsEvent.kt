package com.peterfam.markit.feature_note.presentation.mark_details

import androidx.compose.ui.focus.FocusState

sealed class MarkDetailsEvent {
    data class EnteredTitle(val value: String) : MarkDetailsEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : MarkDetailsEvent()
    data class EnteredContent(val value: String) : MarkDetailsEvent()
    data class ChangeContentFocus(val focusState: FocusState) : MarkDetailsEvent()
    data class ChangeColor(val color: Int) : MarkDetailsEvent()
    object SaveMark : MarkDetailsEvent()
}
