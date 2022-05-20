package br.ftdev.heroisdamarvel.di

import br.ftdev.heroisdamarvel.BuildConfig
import br.ftdev.heroisdamarvel.data.api.HeroService
import br.ftdev.heroisdamarvel.data.utils.WebServiceFactory
import br.ftdev.heroisdamarvel.domain.database.HeroDatabase
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepository
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        WebServiceFactory.createWebService<HeroService>(BuildConfig.MARVEL_API_URL)
    }

    factory<HeroServiceRepository> { HeroServiceRepositoryImpl(get(), get()) }

    single { HeroDatabase.loadDatabase(androidContext()) }
}
