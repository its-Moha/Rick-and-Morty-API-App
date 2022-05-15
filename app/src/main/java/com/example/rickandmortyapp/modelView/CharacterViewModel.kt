package com.example.rickandmortyapp.modelView

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.ScreenState
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.model.CharacterResponse
import com.example.rickandmortyapp.network.RetrofitInstance
import com.example.rickandmortyapp.network.api
import com.example.rickandmortyapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterViewModel( private val repository: Repository
        = Repository(RetrofitInstance.api)): ViewModel() {


    var getCharacterList = MutableLiveData<ScreenState<List<Character>>>()

    val characterLiveData:LiveData<ScreenState<List<Character>>>
    get() = getCharacterList


    fun getData() {


        //loading data
        getCharacterList.postValue(ScreenState.Loading(null))


        viewModelScope.launch(Dispatchers.IO) {
            Log.d("CharacterViewModel",Thread.currentThread().name)
            try {
                var client = repository.getCharacters("1")
                getCharacterList.postValue(ScreenState.Success(client.result))
            } catch (e: Exception) {
                getCharacterList.postValue(ScreenState.Error(e.message.toString(), null))
            }
        }

    }
}


//        if (response.isSuccessful){
//            getCharacterList.postValue(ScreenState.Success(response.body()?.result))
//        }else{
//            getCharacterList.postValue(ScreenState.Error(response.body()?.result.toString()))
//        }
//        getCharacterList.postValue(ScreenState.Error(t.message.toString(),null))

