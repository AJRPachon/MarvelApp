package es.ajrpachon.comiclist.ui.viewmodel

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.ajrpachon.comiclist.domain.GetCharacterComicListUseCase
import es.ajrpachon.comiclist.ui.fragment.CharacterComicListDirections
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.common.util.lifecycle.MutableSourceLiveData
import es.ajrpachon.data.model.charactercomic.CharacterComicBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterComicListViewModel @Inject constructor(
    private val getCharacterComicListUseCase : GetCharacterComicListUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val characterComicListLiveData = MutableSourceLiveData<AsyncResult<List<CharacterComicBo>>>(dispatchers)

    fun getCharacterComicListLiveData() = characterComicListLiveData.liveData()

    fun requestCharactersComicList(id: Long) {
        viewModelScope.launch(dispatchers.io) {
            characterComicListLiveData.changeSource(
                getCharacterComicListUseCase.invoke(id).asLiveData(
                    coroutineContext
                )
            )
        }
    }

    fun goToComicDetail(id : Long) {
        navigate(CharacterComicListDirections.actionCharacterComicListToCharacterComicDetail(id))
    }
}