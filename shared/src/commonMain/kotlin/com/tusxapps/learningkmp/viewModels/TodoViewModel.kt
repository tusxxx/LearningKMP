package com.tusxapps.learningkmp.viewModels

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.tusxapps.learningkmp.domain.TodoItem
import com.tusxapps.learningkmp.domain.TodoRepository
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val todoRepository: TodoRepository
) : KMMViewModel() {
    suspend fun saveTodo(todoItem: TodoItem) {
        todoRepository.save(todoItem)
        fetchTodos()
    }

    private val _todos = MutableStateFlow(viewModelScope, emptyList<TodoItem>())
    val todos = _todos.asStateFlow()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.coroutineScope.launch {
            todoRepository.getAll().onSuccess {
                _todos.emit(it)
            }
        }
    }
}