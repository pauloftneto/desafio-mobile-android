package br.ftdev.heroisdamarvel.di

import br.ftdev.heroisdamarvel.presetation.HeroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeroViewModel(get()) }
}
