package thearith.rxjavamvvm.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import thearith.rxjavamvvm.repo.MainRepo
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepo
) : ViewModel() {

    val posts = repo.getPosts()

}