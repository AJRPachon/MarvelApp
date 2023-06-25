package es.ajrpachon.characterlist.ui.viewmodel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.ajrpachon.characterlist.domain.GetCharacterUseCase
import es.ajrpachon.characterlist.ui.fragment.MainCharactersFragmentDirections
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.common.util.lifecycle.MutableSourceLiveData
import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainCharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val dispatchers: AppDispatchers
): BaseViewModel() {

    private var characterThorListLiveData = MutableSourceLiveData<AsyncResult<CommonBaseBo>>(dispatchers)
    private var characterCaptainAmericaListLiveData = MutableSourceLiveData<AsyncResult<CommonBaseBo>>(dispatchers)
    private var characterHulkListLiveData = MutableSourceLiveData<AsyncResult<CommonBaseBo>>(dispatchers)
    private var characterIronManListLiveData = MutableSourceLiveData<AsyncResult<CommonBaseBo>>(dispatchers)

    fun getCharacterThorLiveData() = characterThorListLiveData.liveData()
    fun getCharacterCaptainAmericaLiveData() = characterCaptainAmericaListLiveData.liveData()
    fun getCharacterHulkLiveData() = characterHulkListLiveData.liveData()
    fun getCharacterIronManLiveData() = characterIronManListLiveData.liveData()

    fun requestMainCharacters() {
        requestCharacterThor()
        requestCharacterCaptainAmerica()
        requestCharacterHulk()
        requestCharacterIronMan()
    }

    private fun requestCharacterThor() {
        viewModelScope.launch(dispatchers.io) {
            characterThorListLiveData.changeSource(
                getCharacterUseCase.invoke(1009664).asLiveData(
                    coroutineContext
                )
            )
        }

    }

    private fun requestCharacterCaptainAmerica() {
        viewModelScope.launch(dispatchers.io) {
            characterCaptainAmericaListLiveData.changeSource(
                getCharacterUseCase.invoke(1009220).asLiveData(
                    coroutineContext
                )
            )
        }
    }

    private fun requestCharacterHulk() {
        viewModelScope.launch(dispatchers.io) {

            characterHulkListLiveData.changeSource(
                getCharacterUseCase.invoke(1009351).asLiveData(
                    coroutineContext
                )
            )
        }
    }

    private fun requestCharacterIronMan() {
        viewModelScope.launch(dispatchers.io) {
            characterIronManListLiveData.changeSource(
                getCharacterUseCase.invoke(1009368).asLiveData(
                    coroutineContext
                )
            )
        }
    }

    fun goToCharacterComicList(id: Long) {
        navigate(MainCharactersFragmentDirections.actionMainCharactersToCharacterComicList(id))
    }



}