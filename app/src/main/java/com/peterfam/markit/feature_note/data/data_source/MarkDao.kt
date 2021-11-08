package com.peterfam.markit.feature_note.data.data_source

import androidx.room.*
import com.peterfam.markit.feature_note.domain.model.Mark
import kotlinx.coroutines.flow.Flow

@Dao
interface MarkDao {

    @Query("SELECT * FROM mark")
    fun getMarks(): Flow<List<Mark>>

    @Query("SELECT * FROM mark WHERE id = :id")
    suspend fun getMarkByID(id: Int): Mark?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMark(mark: Mark)

    @Delete
    suspend fun deleteMark(mark: Mark)
}