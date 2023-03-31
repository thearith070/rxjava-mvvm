package thearith.rxjavamvvm.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.Disposable
import thearith.rxjavamvvm.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var postsAdapter: PostsAdapter

    private lateinit var binding: ActivityMainBinding

    private var disposable: Disposable? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPostList()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
        disposable = null
    }

    private fun setupPostList() {
        binding.rv.adapter = postsAdapter
        disposable = viewModel.posts.subscribe({ data ->
            postsAdapter.submitList(data)
        }, { throwable ->
            Toast.makeText(this, throwable.message.toString(), Toast.LENGTH_LONG).show()
            throwable.printStackTrace()
        })
    }

}