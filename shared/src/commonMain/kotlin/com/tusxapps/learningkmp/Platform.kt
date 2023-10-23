package com.tusxapps.learningkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform