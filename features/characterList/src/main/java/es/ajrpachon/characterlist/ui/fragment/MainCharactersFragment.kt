package es.ajrpachon.characterlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.characterlist.R
import es.ajrpachon.characterlist.databinding.FragmentMainCharactersBinding
import es.ajrpachon.characterlist.ui.viewmodel.CharacterListViewModel
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.data.repository.util.AsyncResult

@AndroidEntryPoint
class MainCharactersFragment : BaseFragment() {

    private val viewModel: CharacterListViewModel by viewModelBinder(R.id.nav_graph__main_characters_feature)

    private var binding: FragmentMainCharactersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCharactersBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureObservers()
    }

    private fun configureObservers() {
        viewModel.requestMainCharacters()
        viewModel.getCharacterThorLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is AsyncResult.Success -> {
                    binding?.let { bindingNoNull ->
                        with(bindingNoNull) {

                            Glide.with(this.root)
                                .load(getSecureUrl("${it.data?.image?.path}.${it.data?.image?.extension}"))
                                .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                                .fitCenter()
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .skipMemoryCache(true)
                                .into(mainCharactersImgThor)

                            mainCharactersImgThor.setOnClickListener { _ ->
                                viewModel.goToCharacterComicList(it.data?.id?.toLong() ?: 0L)
                            }
                        }
                    }

                }

                is AsyncResult.Error -> { /* no-op */ }

                is AsyncResult.Loading -> { /* no-op */ }
            }
        }

        viewModel.getCharacterCaptainAmericaLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is AsyncResult.Success -> {
                    binding?.let { bindingNoNull ->
                        with(bindingNoNull) {
                            Glide.with(this.root)
                                .load(getSecureUrl("${it.data?.image?.path}.${it.data?.image?.extension}"))
                                .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .skipMemoryCache(true)
                                .into(mainCharactersImgCaptainAmerica)

                            mainCharactersImgCaptainAmerica.setOnClickListener { _ ->
                                viewModel.goToCharacterComicList(it.data?.id?.toLong() ?: 0L)
                            }
                        }
                    }

                }

                is AsyncResult.Error -> { /* no-op */ }

                is AsyncResult.Loading -> { /* no-op */ }
            }
        }

        viewModel.getCharacterHulkLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is AsyncResult.Success -> {
                    binding?.let { bindingNoNull ->
                        with(bindingNoNull) {
                            Glide.with(this.root)
                                .load(getSecureUrl("${it.data?.image?.path}.${it.data?.image?.extension}"))
                                .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .skipMemoryCache(true)
                                .into(mainCharactersImgHulk)

                            mainCharactersImgHulk.setOnClickListener { _ ->
                                viewModel.goToCharacterComicList(it.data?.id?.toLong() ?: 0L)
                            }
                        }
                    }

                }

                is AsyncResult.Error -> { /* no-op */ }

                is AsyncResult.Loading -> { /* no-op */ }
            }
        }

        viewModel.getCharacterIronManLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is AsyncResult.Success -> {
                    binding?.let { bindingNoNull ->
                        with(bindingNoNull) {
                            Glide.with(this.root)
                                .load(getSecureUrl("${it.data?.image?.path}.${it.data?.image?.extension}"))
                                .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .skipMemoryCache(true)
                                .into(mainCharactersImgIronMan)

                            mainCharactersImgIronMan.setOnClickListener { _ ->
                                viewModel.goToCharacterComicList(it.data?.id?.toLong() ?: 0L)
                            }
                        }
                    }

                }

                is AsyncResult.Error -> { /* no-op */ }

                is AsyncResult.Loading -> { /* no-op */ }
            }
        }
    }


    //TODO mover a utils
    private fun getSecureUrl(originalUrl: String): String {
        return originalUrl.replace("http://", "https://")
    }


    override fun getViewModel() = viewModel as BaseViewModel

}