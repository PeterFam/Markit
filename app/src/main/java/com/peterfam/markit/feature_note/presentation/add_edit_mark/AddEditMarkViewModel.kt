package com.peterfam.markit.feature_note.presentation.add_edit_mark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterfam.markit.feature_note.domain.model.InvalidMarkException
import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.use_case.MarkItUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditMarkViewModel @Inject constructor(
    private val markItUseCases: MarkItUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _markTitle = mutableStateOf(MarkTextFieldState(
        hint = "Enter title..."
    ))
    val markTitle : State<MarkTextFieldState> = _markTitle

    private val _markContent = mutableStateOf(MarkTextFieldState(
        hint = "Enter here..."
    ))
    val markContent : State<MarkTextFieldState> = _markTitle

    private val _markColor = mutableStateOf(Mark.markColors.random().toArgb())
    val markColor: State<Int> = _markColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentMarkId :Int? = null

    init {
        savedStateHandle.get<Int>("markId")?.let { markId ->
            if(markId != -1){
                viewModelScope.launch {
                    markItUseCases.getMarkByIdUseCase(markId)?.also { mark ->
                        currentMarkId = mark.id
                        _markTitle.value = markTitle.value.copy(
                            text = mark.title,
                            isHintVisible = false
                        )
                        _markContent.value = markContent.value.copy(
                            text = mark.content,
                            isHintVisible = false
                        )
                        _markColor.value = mark.color
                    }
                }
            }
        }
    }
    fun onEvent(event: AddEditMarkEvent){
        when(event){
            is AddEditMarkEvent.EnteredTitle -> {
                _markTitle.value = markTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditMarkEvent.ChangeTitleFocus -> {
                _markTitle.value = markTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused && _markTitle.value.text.isBlank()
                )
            }
            is AddEditMarkEvent.EnteredContent -> {
                _markContent.value = markContent.value.copy(
                    text = event.value
                )
            }
            is AddEditMarkEvent.ChangeContentFocus -> {
                _markContent.value = markContent.value.copy(
                    isHintVisible = !event.focusState.isFocused && _markContent.value.text.isBlank()
                )
            }
            is AddEditMarkEvent.ChangeColor -> {
                _markColor.value = event.color
            }
            is AddEditMarkEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        markItUseCases.addMarkUseCase(
                            Mark(
                                title = markTitle.value.text,
                                content = markContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = markColor.value,
                                id = currentMarkId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveMark)
                    }catch (e: InvalidMarkException){
                        UiEvent.ShowSnackBar(
                            message = e.message ?: "Couldn't save mark"
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent{
         data class ShowSnackBar(val message: String): UiEvent()
        object SaveMark: UiEvent()
    }
}