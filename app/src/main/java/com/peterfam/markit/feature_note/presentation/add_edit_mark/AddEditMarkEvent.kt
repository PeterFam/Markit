package com.peterfam.markit.feature_note.presentation.add_edit_mark

import androidx.compose.ui.focus.FocusState

sealed class AddEditMarkEvent{
    data class EnteredTitle(val value: String): AddEditMarkEvent()
    data class ChangeTitleFocus(val focusState:FocusState): AddEditMarkEvent()
    data class EnteredContent(val value: String): AddEditMarkEvent()
    data class ChangeContentFocus(val focusState:FocusState): AddEditMarkEvent()
    data class ChangeColor(val color: Int): AddEditMarkEvent()
    object SaveNote : AddEditMarkEvent()
}
