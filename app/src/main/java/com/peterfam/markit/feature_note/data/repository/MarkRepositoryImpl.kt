package com.peterfam.markit.feature_note.data.repository

import com.peterfam.markit.feature_note.data.data_source.MarkDao
import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkRepository
import kotlinx.coroutines.flow.Flow

class MarkRepositoryImpl(private val markDao: MarkDao) : MarkRepository {

    override fun getMarks(): Flow<List<Mark>> = markDao.getMarks()

    override suspend fun getMarkByID(id: Int) = markDao.getMarkByID(id)
    
    override suspend fun addMark(mark: Mark) = markDao.addMark(mark)

    override suspend fun deleteMark(mark: Mark) = markDao.deleteMark(mark)
}