package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository

class DeleteMarkUseCase(private val repository: MarkItRepository) {

    suspend operator fun invoke(mark: Mark){
        repository.deleteMark(mark)
    }
}