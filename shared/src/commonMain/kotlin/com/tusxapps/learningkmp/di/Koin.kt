package com.tusxapps.learningkmp.di

import com.tusxapps.learningkmp.data.TodoRepositoryImpl
import com.tusxapps.learningkmp.data.database.TodoDatabase
import com.tusxapps.learningkmp.data.database.TodoDatabaseMock
import com.tusxapps.learningkmp.domain.TodoRepository
import com.tusxapps.learningkmp.viewModels.TodoViewModel
import org.koin.dsl.module

private val commonModule = module {
    single<TodoDatabase> {
        TodoDatabaseMock
    }
    single<TodoRepository> {
        TodoRepositoryImpl(get())
    }
    single {
        TodoViewModel(get())
    }
}

private val platformModule = module {

}

fun sharedModule() = listOf(commonModule, platformModule)