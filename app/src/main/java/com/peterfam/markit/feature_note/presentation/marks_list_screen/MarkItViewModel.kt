package com.peterfam.markit.feature_note.presentation.marks_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.use_case.MarkItUseCases
import com.peterfam.markit.feature_note.domain.util.MarkOrder
import com.peterfam.markit.feature_note.domain.util.OrderType
import com.peterfam.markit.feature_note.presentation.marks_list_screen.MarkItEvent
import com.peterfam.markit.feature_note.presentation.marks_list_screen.MarkItState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarkItViewModel @Inject constructor(
    private val markItUseCases: MarkItUseCases
): ViewModel(){

    private val _state = mutableStateOf(MarkItState())
    val state: State<MarkItState> = _state

    private var recentlyDeletedMark: Mark? = null

    private var getMarksJob: Job? = null

    init {
        getMarks(MarkOrder.Date(OrderType.DESC))
    }
    fun onEvent(event: MarkItEvent){
        when(event){
           is MarkItEvent.Order -> {
                if(state.value.marksOrder::class == event.markOrder::class &&
                        state.value.marksOrder.orderType == event.markOrder.orderType){
                    return
                }
            }
            is MarkItEvent.DeleteNote -> {
                viewModelScope.launch {
                    markItUseCases.deleteMarkUseCase(event.mark)
                    recentlyDeletedMark = event.mark
                }
            }
            is MarkItEvent.RestoreMark -> {
                    viewModelScope.launch {
                        markItUseCases.addMarkUseCase(recentlyDeletedMark ?: return@launch)
                        recentlyDeletedMark = null
                    }
            }
            is MarkItEvent.ToggleOrderSection -> {
            _state.value = state.value.copy(
                isOrderSectionVisible = !state.value.isOrderSectionVisible
            )
            }
        }
    }
    private fun getMarks(markOrder: MarkOrder){
        getMarksJob?.cancel()
        getMarksJob = markItUseCases.getMarksUseCase(markOrder).onEach { marks ->
            _state.value = state.value.copy(marks = marks,
            marksOrder = markOrder)
        }.launchIn(viewModelScope)
    }
}