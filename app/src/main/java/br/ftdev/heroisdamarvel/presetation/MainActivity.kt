package br.ftdev.heroisdamarvel.presetation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.ftdev.heroisdamarvel.databinding.ActivityMainBinding
import br.ftdev.heroisdamarvel.presetation.adapter.HeroListAdapter
import br.ftdev.heroisdamarvel.presetation.adapter.ItemAdapter
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val heroViewModel: HeroViewModel by viewModel()
    private lateinit var viewBinding: ActivityMainBinding

    private var adapter = HeroListAdapter()
    private var itemAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()

        fetchData()
        setupObservers()
    }

    private fun fetchData() {
        heroViewModel.getHeroes()
    }

    private fun setupObservers() {
        heroViewModel.heroes.observe(this) { heroes ->
            viewBinding.loading.isVisible = heroes.isLoading
            viewBinding.recyclerView.isVisible = !heroes.isLoading

            heroes.error?.let { error -> setupError(error) }

            adapter.submitList(heroes.listHeroes)
            if (heroes.listHeroes.isNotEmpty()) {
                itemAdapter.submitList(heroes.listHeroes.subList(0, 5))
            }
        }
    }

    private fun setupUi() {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupAdapter()
    }

    private fun setupAdapter() {
        viewBinding.carousel.initialize(itemAdapter)

        viewBinding.recyclerView.adapter = adapter
    }

    private fun setupError(error: Int) {
        Snackbar.make(viewBinding.root, getString(error), Snackbar.LENGTH_LONG).show()
    }

}