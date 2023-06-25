package es.ajrpachon.characterlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.characterlist.R
import es.ajrpachon.characterlist.databinding.FragmentCharacterListBinding
import es.ajrpachon.characterlist.ui.adapter.CharacterListAdapter
import es.ajrpachon.characterlist.ui.viewmodel.CharacterListViewModel
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.data.model.character.CharacterBo

@AndroidEntryPoint
class CharacterListFragment : BaseFragment() {

    private val viewModel: CharacterListViewModel by viewModelBinder(R.id.nav_graph__character_list_feature)

    private var binding : FragmentCharacterListBinding? = null

    private val adapter by lazy { CharacterListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureBindings()
    }

    private fun configureBindings() {
        binding?.let {
            with(it) {
                characterListListCharacters.layoutManager = GridLayoutManager(
                    requireActivity().applicationContext,
                    2,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                characterListListCharacters.adapter = adapter
            }
        }
    }

    override fun getViewModel() = viewModel as BaseViewModel

}