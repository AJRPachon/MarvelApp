package es.ajrpachon.comicdetail.ui.viewmodel

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.ajrpachon.comicdetail.domain.GetComicDetailUseCase
import es.ajrpachon.common.ui.BaseViewModel
import es.ajrpachon.common.util.lifecycle.MutableSourceLiveData
import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicDetailViewModel @Inject constructor(
    private val getComicDetailUseCase: GetComicDetailUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private var comicDetailLiveData = MutableSourceLiveData<AsyncResult<CommonBaseBo>>(dispatchers)

    fun getComicDetailLiveData() = comicDetailLiveData.liveData()

    fun requestComicDetail(id: Long) {
        viewModelScope.launch(dispatchers.io) {
            comicDetailLiveData.changeSource(
                getComicDetailUseCase.invoke(id).asLiveData(
                    coroutineContext
                )
            )
        }
    }

}