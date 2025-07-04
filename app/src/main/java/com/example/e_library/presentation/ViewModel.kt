package com.example.e_library.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_library.common.BookCategoryModel
import com.example.e_library.common.BookModel
import com.example.e_library.common.ResultState
import com.example.e_library.domain.repo.AllBookRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(val repo: AllBookRepo) : ViewModel() {

    private val _state : MutableState<ItemState> = mutableStateOf(ItemState())
    val state : MutableState<ItemState> = _state

    fun BringAllBooks() {
        viewModelScope.launch {
            repo.getAllBook().collect {


                when(it) {
                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }

                    is ResultState.Success -> {
                        _state.value = ItemState(items = it.data)
                    }
                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.localizedMessage)
                    }
                }
            }
        }
    }

    fun BringCategories() {
        viewModelScope.launch {
            repo.getAllCategory().collect {

                when(it) {
                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }

                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.localizedMessage)
                    }

                    is ResultState.Success -> {

                        _state.value= ItemState(category = it.data)
                    }
                }
            }
        }
    }

    fun BringAllBooksByCategory(category : String){

        viewModelScope.launch {
            repo.getAllBooksByCategory(category).collect {

                when(it) {
                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }
                    is ResultState.Error -> {

                        _state.value = ItemState(error = it.exception.localizedMessage)
                    }
                  is ResultState.Success -> {

                      _state.value = ItemState(items = it.data)
                  }
                }
            }
        }
    }
}



data class ItemState(
    val isLoading: Boolean = false,
    val items: List<BookModel> = emptyList(),
    val error: String = "",
    val category : List<BookCategoryModel> = emptyList()
)