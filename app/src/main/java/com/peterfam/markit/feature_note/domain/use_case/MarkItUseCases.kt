package com.peterfam.markit.feature_note.domain.use_case

data class MarkItUseCases(
    val getMarksUseCase: GetMarksUseCase,
    val addMarkUseCase: AddMarkUseCase,
    val deleteMarkUseCase: DeleteMarkUseCase,
    val getMarkByIdUseCase: GetMarkByIdUseCase
)
