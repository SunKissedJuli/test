package com.example.sobes.di

import com.example.sobes.data.api.SobesApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module


internal val apiModule = module {
     factory { get<Ktorfit>().create<SobesApi>() }
}