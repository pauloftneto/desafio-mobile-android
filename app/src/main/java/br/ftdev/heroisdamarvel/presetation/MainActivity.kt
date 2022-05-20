package br.ftdev.heroisdamarvel.presetation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ftdev.heroisdamarvel.R
import br.ftdev.heroisdamarvel.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val heroViewModel: HeroViewModel by viewModel()
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        heroViewModel.getHeroes()
    }

}