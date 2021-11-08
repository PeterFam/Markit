package com.peterfam.markit.feature_note.data.repository

import com.peterfam.markit.feature_note.data.data_source.MarkItDao
import com.peterfam.markit.feature_note.domain.model.Mark
import com.peterfam.markit.feature_note.domain.repository.MarkItRepository
import kotlinx.coroutines.flow.Flow

class MarkItRepositoryImpl(private val markItDao: MarkItDao) : MarkItRepository {

    override fun getMarks(): Flow<List<Mark>> = markItDao.getMarks()

    override suspend fun getMarkByID(id: Int) = markItDao.getMarkByID(id)
    
    override suspend fun addMark(mark: Mark) = markItDao.addMark(mark)

    override suspend fun deleteMark(mark: Mark) = markItDao.deleteMark(mark)
}