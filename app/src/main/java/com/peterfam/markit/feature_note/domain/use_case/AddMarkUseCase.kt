package com.peterfam.markit.feature_note.domain.use_case

import com.peterfam.markit.feature_note.domain.model.InvalidMarkException
import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository

class AddMarkUseCase(private val repository: MarkItRepository) {


    @Throws(InvalidMarkException::class)
    suspend operator fun invoke(mark: Mark){
        if(mark.title.isBlank()){
            throw InvalidMarkException("The Title can't be empty.")
        }
        if(mark.content.isBlank()){
            throw InvalidMarkException("The content can't be empty.")
        }
        repository.addMark(mark)
    }
}