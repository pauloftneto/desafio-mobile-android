package br.ftdev.heroisdamarvel.di

import br.ftdev.heroisdamarvel.BuildConfig
import br.ftdev.heroisdamarvel.data.api.HeroService
import br.ftdev.heroisdamarvel.data.local.HeroLocalDataSource
import br.ftdev.heroisdamarvel.data.local.HeroLocalDataSourceImpl
import br.ftdev.heroisdamarvel.data.remote.HeroRemoteDataSource
import br.ftdev.heroisdamarvel.data.remote.HeroRemoteDataSourceImpl
import br.ftdev.heroisdamarvel.data.utils.WebServiceFactory
import br.ftdev.heroisdamarvel.domain.database.HeroDatabase
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepository
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepositoryImpl
import br.ftdev.heroisdamarvel.domain.usecase.HeroUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        WebServiceFactory.createWebService<HeroService>(BuildConfig.MARVEL_API_URL)
    }

    single { HeroDatabase.loadDatabase(androidContext()) }

    factory<HeroServiceRepository> { HeroServiceRepositoryImpl(get()) }

    factory<HeroRemoteDataSource> { HeroRemoteDataSourceImpl(get(), get()) }
    factory<HeroLocalDataSource> { HeroLocalDataSourceImpl(get()) }

    factory { HeroUseCase(get()) }

}
