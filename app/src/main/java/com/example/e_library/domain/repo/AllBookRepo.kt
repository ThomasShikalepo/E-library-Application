package com.example.e_library.domain.repo

import com.example.e_library.common.BookCategoryModel
import com.example.e_library.common.BookModel
import com.example.e_library.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {

    fun getAllBook(): Flow<ResultState<List<BookModel>>>
    fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>
}