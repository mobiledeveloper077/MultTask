package uz.abduvali.multtask.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.multtask.App
import uz.abduvali.multtask.R
import uz.abduvali.multtask.adapters.CharacterAdapter
import uz.abduvali.multtask.databinding.FragmentHomeBinding
import uz.abduvali.multtask.viewmodel.CharacterViewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeFragment : Fragment(R.layout.fragment_home), CoroutineScope {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val characterViewModel: CharacterViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterAdapter = CharacterAdapter(object : CharacterAdapter.OnItemClick {
            override fun onClick(characterEntity: CharacterEntity) {
                findNavController().navigate(R.id.action_homeFragment_to_characterFragment)
            }
        })
        binding.rv.adapter = characterAdapter

        launch {
            characterViewModel.flow.catch {

            }.collect {
                characterAdapter.submitData(it)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}