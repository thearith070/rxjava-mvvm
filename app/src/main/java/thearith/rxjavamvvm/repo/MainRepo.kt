package thearith.rxjavamvvm.repo

import io.reactivex.rxjava3.core.Observable
import thearith.rxjavamvvm.model.PostItem

interface MainRepo {

    fun getPosts(): Observable<List<PostItem>>

}