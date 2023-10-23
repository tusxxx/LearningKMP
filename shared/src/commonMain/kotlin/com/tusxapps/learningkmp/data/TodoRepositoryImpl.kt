package com.tusxapps.learningkmp.data

import com.tusxapps.learningkmp.data.database.TodoDatabase
import com.tusxapps.learningkmp.domain.TodoItem
import com.tusxapps.learningkmp.domain.TodoRepository

class TodoRepositoryImpl(private val todoDatabase: TodoDatabase) : TodoRepository {
    override suspend fun getAll(): Result<List<TodoItem>> = try {
        Result.success(todoDatabase.getAll().map { it.toDomain() })
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun save(todoItem: TodoItem) = try {
        Result.success(todoDatabase.save(todoItem.toEntity()))
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun delete(todoItem: TodoItem) = try {
        Result.success(todoDatabase.deleteById(todoItem.id))
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun update(todoItem: TodoItem) = try {
        Result.success(todoDatabase.updateById(todoItem.id, todoItem.toEntity()).toDomain())
    } catch (e: Exception) {
        Result.failure(e)
    }
}