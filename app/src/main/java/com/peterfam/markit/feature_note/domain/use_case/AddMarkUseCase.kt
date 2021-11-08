package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkRepository

class AddMarkUseCase(private val repository: MarkRepository) {

    suspend operator fun invoke(mark: Mark){
        repository.addMark(mark)
    }
}