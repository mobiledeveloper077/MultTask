package uz.abduvali.multtask.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import uz.abduvali.multtask.R
import uz.abduvali.multtask.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private var url = "https://rickandmortyapi.com/"

    private val binding by viewBinding(FragmentCharacterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            web.loadUrl(url)
        }
    }
}