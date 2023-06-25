package es.ajrpachon.onboarding.ui.viewmodel

import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.onboarding.ui.fragment.OnboardingFragmentDirections

class OnboardingViewModel : BaseViewModel() {

    fun onStartClick() {
        navigate(OnboardingFragmentDirections.actionOnboardingToNavGraphCharacterListFeature())
    }
}