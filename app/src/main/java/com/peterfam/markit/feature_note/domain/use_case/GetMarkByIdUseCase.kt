package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkRepository

class GetMarkByIdUseCase(val repository: MarkRepository) {

    suspend operator fun invoke(id: Int): Mark? {
        return repository.getMarkByID(id)
    }
}