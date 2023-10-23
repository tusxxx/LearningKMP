package com.tusxapps.learningkmp.data

import com.tusxapps.learningkmp.data.database.TodoItemEntity
import com.tusxapps.learningkmp.domain.TodoItem

fun TodoItemEntity.toDomain(): TodoItem {
    return TodoItem(
        id = id,
        title = title,
        description = description,
        isDone = completed
    )
}

fun TodoItem.toEntity(): TodoItemEntity {
    return TodoItemEntity(
        id = id,
        title = title,
        description = description,
        completed = isDone
    )
}