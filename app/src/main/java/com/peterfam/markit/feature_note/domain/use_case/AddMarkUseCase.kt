package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository

class AddMarkUseCase(private val repository: MarkItRepository) {

    suspend operator fun invoke(mark: Mark){
        repository.addMark(mark)
    }
}