package es.ajrpachon.comiclist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.comiclist.R
import es.ajrpachon.comiclist.databinding.FragmentCharacterComicListBinding
import es.ajrpachon.comiclist.ui.adapter.CharacterComicListAdapter
import es.ajrpachon.comiclist.ui.viewmodel.CharacterComicListViewModel
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.data.repository.util.AsyncResult

@AndroidEntryPoint
class CharacterComicList : BaseFragment() {

    private val args: CharacterComicListArgs by navArgs()

    private val viewModel: CharacterComicListViewModel by viewModelBinder(R.id.nav_graph__comic_list_feature)

    private var binding: FragmentCharacterComicListBinding? = null

    private val adapter by lazy {
        CharacterComicListAdapter {
            viewModel.goToComicDetail(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterComicListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureView()
        configureObservers()
    }

    private fun configureView() {
        binding?.let {
            with(it) {
                characterComicListListComicList.layoutManager = GridLayoutManager(
                    requireActivity().applicationContext,
                    2,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                characterComicListListComicList.adapter = adapter
            }
        }
    }

    private fun configureObservers() {
        viewModel.requestCharactersComicList(args.characterId)
        viewModel.getCharacterComicListLiveData().observe(viewLifecycleOwner) { result ->
            when (result) {
                is AsyncResult.Success -> {
                    binding?.hideLoading()
                    adapter.submitList(result.data)
                }

                is AsyncResult.Error -> {
                    binding?.hideLoading()
                }

                is AsyncResult.Loading -> {
                    binding?.showLoading()
                }
            }
        }
    }

    private fun FragmentCharacterComicListBinding.showLoading() {
        characterComicListListComicList.visibility = View.GONE
        characterComicListProgressBarLoading.visibility = View.VISIBLE
    }

    private fun FragmentCharacterComicListBinding.hideLoading() {
        characterComicListListComicList.visibility = View.VISIBLE
        characterComicListProgressBarLoading.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun getViewModel() = viewModel as BaseViewModel

}