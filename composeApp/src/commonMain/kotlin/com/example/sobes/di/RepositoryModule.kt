package com.example.sobes.di

import com.example.sobes.domain.repository.Repository
import com.example.sobes.data.repositoryImpl.RepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    factoryOf(::RepositoryImpl) { bind<Repository>() }
}

