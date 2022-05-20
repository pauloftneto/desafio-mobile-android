package br.ftdev.heroisdamarvel

import android.app.Application
import br.ftdev.heroisdamarvel.di.dataModule
import br.ftdev.heroisdamarvel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    dataModule,
                )
            ).androidContext(this@App)
        }
    }
}