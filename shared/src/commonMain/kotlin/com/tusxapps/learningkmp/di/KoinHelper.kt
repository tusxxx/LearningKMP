package com.tusxapps.learningkmp.di

import org.koin.core.context.startKoin


fun initKoin(){
    startKoin {
        modules(sharedModule())
    }
}