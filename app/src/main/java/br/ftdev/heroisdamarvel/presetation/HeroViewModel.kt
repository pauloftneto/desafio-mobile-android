package br.ftdev.heroisdamarvel.presetation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ftdev.heroisdamarvel.domain.extensions.handleErrorApiMessage
import br.ftdev.heroisdamarvel.domain.model.Hero
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HeroViewModel(private val heroServiceRepository: HeroServiceRepository) : ViewModel() {

    data class HeroState(
        val listHeroes: List<Hero> = emptyList(),
        val error: Int? = null,
        val isLoading: Boolean = true
    )

    private val _heroes = MutableLiveData(HeroState())
    val heroes: MutableLiveData<HeroState> = _heroes

    fun getHeroes() {
        viewModelScope.launch {
            heroServiceRepository.getHeroes()
                .catch { error ->
                    val apiException = error.handleErrorApiMessage()
                    _heroes.postValue(HeroState(error = apiException, isLoading = false))
                }.collect { heroList ->
                    _heroes.postValue(HeroState(listHeroes = heroList, isLoading = false))
                }

        }
    }

}
