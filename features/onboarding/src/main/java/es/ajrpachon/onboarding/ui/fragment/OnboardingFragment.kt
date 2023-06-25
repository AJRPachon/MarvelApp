package es.ajrpachon.onboarding.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import es.ajrpachon.common.ui.BaseFragment
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.onboarding.R
import es.ajrpachon.onboarding.databinding.FragmentOnboardingBinding
import es.ajrpachon.onboarding.ui.viewmodel.OnboardingViewModel

@AndroidEntryPoint
class OnboardingFragment : BaseFragment() {

    private val viewModel: OnboardingViewModel by viewModelBinder(R.id.nav_graph__on_boarding_feature)

    private var binding: FragmentOnboardingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding?.let {
            with(it) {
                onboardingBtnStart.setOnClickListener {
                    viewModel.onStartClick()
                }
            }
        }
    }

    override fun getViewModel() = viewModel as BaseViewModel

}