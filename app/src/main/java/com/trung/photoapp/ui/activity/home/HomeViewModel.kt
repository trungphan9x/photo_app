package com.trung.photoapp.ui.activity.home

import androidx.lifecycle.MutableLiveData
import com.trung.photoapp.core.BaseViewModel

class HomeViewModel : BaseViewModel() {
    val searchLiveData = MutableLiveData<String?>()
}