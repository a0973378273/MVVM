package bean.sample.mvvm.view.activity

import android.content.SharedPreferences
import android.util.Log
import androidx.activity.viewModels
import bean.sample.mvvm.databinding.ActivityMainBinding
import bean.sample.mvvm.viewmodel.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint
import priv.jb.base.basic.BaseActivity
import javax.inject.Inject

@AndroidEntryPoint
class FirstActivity : BaseActivity<ActivityMainBinding>() {

    private val firstViewModel: FirstViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun init() {}

    override fun initAction() {
        firstViewModel.todosDataLiveData.observe(this) {
            /*show data*/
            Log.d(localClassName, "todosDataLiveData: $it")
        }
        firstViewModel.errorLivedata.observe(this) {
            /*show error dialog*/
            Log.d(localClassName, "errorLivedata: $it")
        }
        firstViewModel.loadingLiveData.observe(this) {
            if (it) {
                /*show loading*/
                Log.d(localClassName, "loadingLiveData: $it")
            } else {
                /* hide loading*/
                Log.d(localClassName, "loadingLiveData: $it")
            }
        }

        binding.button2.setOnClickListener {
            sharedPreferences.edit().putString("token", "4").commit()
            firstViewModel.updateTodosData()
        }
    }

    override fun initView() {}

}