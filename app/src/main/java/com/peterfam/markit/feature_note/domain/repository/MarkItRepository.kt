package com.peterfam.markit.feature_note.domain.repository

import com.peterfam.markit.feature_note.domain.model.Mark
import kotlinx.coroutines.flow.Flow

interface MarkItRepository {

    fun getMarks(): Flow<List<Mark>>

    suspend fun getMarkByID(id: Int): Mark?

    suspend fun addMark(mark: Mark)

    suspend fun deleteMark(mark: Mark)
}