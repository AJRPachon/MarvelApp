package es.ajrpachon.comicdetail.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.comicdetail.R
import es.ajrpachon.comicdetail.databinding.FragmentComicDetailBinding
import es.ajrpachon.comicdetail.ui.viewmodel.ComicDetailViewModel
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.common.util.utils.getSecureUrl
import es.ajrpachon.data.repository.util.AsyncResult

@AndroidEntryPoint
class ComicDetailFragment : BaseFragment() {

    private val args : ComicDetailFragmentArgs by navArgs()

    private val viewModel: ComicDetailViewModel by viewModelBinder(R.id.nav_graph__comic_detail_feature)

    private var binding : FragmentComicDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureObservers()
    }

    private fun configureObservers() {
        viewModel.requestComicDetail(args.comicId)
        viewModel.getComicDetailLiveData().observe(viewLifecycleOwner) { result ->
            when(result) {

                is AsyncResult.Success -> {
                    binding?.let { bindingNoNull ->
                        with(bindingNoNull) {

                            hideLoading()

                            comicDetailLblComicTitle.text = result.data?.title
                            comicDetailLblComicDescription.text = result.data?.description

                            Glide.with(this.root)
                                .load(getSecureUrl("${result.data?.image?.path}.${result.data?.image?.extension}"))
                                .error(es.ajrpachon.common.R.drawable.ic_launcher_background)
                                .fitCenter()
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .skipMemoryCache(true)
                                .into(comicDetailImgComicImg)
                        }
                    }

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

    private fun FragmentComicDetailBinding.showLoading() {
        comicDetailLblComicTitle.visibility = View.GONE
        comicDetailImgComicImg.visibility = View.GONE
        comicDetailLblComicDescription.visibility = View.GONE
        comicDetailProgressBarLoading.visibility = View.VISIBLE
    }

    private fun FragmentComicDetailBinding.hideLoading() {
        comicDetailLblComicTitle.visibility = View.VISIBLE
        comicDetailImgComicImg.visibility = View.VISIBLE
        comicDetailLblComicDescription.visibility = View.VISIBLE
        comicDetailProgressBarLoading.visibility = View.GONE
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun getViewModel() = viewModel as BaseViewModel

}