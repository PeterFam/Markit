package com.peterfam.markit.feature_note.domain.use_case

data class MarkUseCases(
    val getMarksUseCase: GetMarksUseCase,
    val addMarkUseCase: AddMarkUseCase,
    val deleteMarkUseCase: DeleteMarkUseCase,
    val getMarkByIdUseCase: GetMarkByIdUseCase
)
