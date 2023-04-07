package dev.redfox.trueclub.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.redfox.trueclub.models.DataModel
import dev.redfox.trueclub.networking.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    private val _response = MutableLiveData<Response<DataModel>>()

    val response: LiveData<Response<DataModel>> get() = _response

    fun getDetails(name: String) {
        viewModelScope.launch {
            val dResponse = repository.getDetails(name)
            _response.value = dResponse
        }
    }
}
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}