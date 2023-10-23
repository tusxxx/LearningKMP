package com.tusxapps.learningkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.tusxapps.learningkmp.domain.TodoItem
import com.tusxapps.learningkmp.viewModels.TodoViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import kotlin.random.Random
import kotlin.random.nextULong

class MainActivity : ComponentActivity() {
    private val viewModel by inject<TodoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todos by viewModel.todos.collectAsState()
            MyApplicationTheme {
                Column {
                    LazyColumn {
                        items(todos) {
                            Text(text = it.toString())
                        }
                        item {
                            Button(onClick = {
                                lifecycleScope.launch {
                                    viewModel.saveTodo(
                                        TodoItem(
                                            Random.nextULong(),
                                            "Todo 1",
                                            "Description 1",
                                            false
                                        )
                                    )
                                }
                            }) {
                                Text(text = "Save")
                            }
                        }
                    }
                }
            }
        }
    }
}
