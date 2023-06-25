package es.ajrpachon.characterlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.characterlist.R
import es.ajrpachon.characterlist.databinding.FragmentCharacterListBinding
import es.ajrpachon.characterlist.ui.viewmodel.CharacterListViewModel
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel

@AndroidEntryPoint
class CharacterListFragment : BaseFragment() {

    private val viewModel: CharacterListViewModel by viewModelBinder(R.id.nav_graph__character_list_feature)

    private var binding : FragmentCharacterListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun getViewModel() = viewModel as BaseViewModel

}