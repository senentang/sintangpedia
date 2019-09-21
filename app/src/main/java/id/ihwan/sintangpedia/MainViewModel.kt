package id.ihwan.sintangpedia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val restApi = ServiceFactory.create()
    var liveDataListPlace: MutableLiveData<MutableList<Place>> = MutableLiveData()

    fun getListPlace() {
        viewModelScope.launch {
            try {
                val result = restApi.getPlace()
                if (result.isSuccessful) {
                    liveDataListPlace.postValue(result.body())
                }
            } catch (exception: Exception) {

                exception.printStackTrace()
            }
        }
    }
}