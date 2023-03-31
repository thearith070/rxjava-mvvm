package thearith.rxjavamvvm.rest

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import thearith.rxjavamvvm.model.PostItem

interface RestApi {

    @GET("posts")
    fun getComment(): Observable<List<PostItem>>

}