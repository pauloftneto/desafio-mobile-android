package br.ftdev.heroisdamarvel.presetation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.ftdev.heroisdamarvel.R
import br.ftdev.heroisdamarvel.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val heroViewModel: HeroViewModel by viewModel()
    private lateinit var viewBinding: ActivityMainBinding

    private lateinit var adapter: HeroListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObservers()
        fetchData()
    }

    private fun fetchData(){
        heroViewModel.getHeroes()
    }

    private fun setupObservers(){
        heroViewModel.heroes.observe(this) { heroes ->
            heroes.error?.let { error -> setupError(error) }
            adapter.submitList(heroes.listHeroes)
        }
    }

    private fun setupUi(){
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = HeroListAdapter()
        viewBinding.recyclerView.adapter = adapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupError(error: Int) {
        Snackbar.make(viewBinding.root, getString(error), Snackbar.LENGTH_LONG).show()
    }

}