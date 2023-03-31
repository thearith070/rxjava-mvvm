package thearith.rxjavamvvm.repo

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import thearith.rxjavamvvm.model.PostItem
import thearith.rxjavamvvm.rest.RestApi
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val api: RestApi
) : MainRepo {

    override fun getPosts(): Observable<List<PostItem>> {
        return api.getComment()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}