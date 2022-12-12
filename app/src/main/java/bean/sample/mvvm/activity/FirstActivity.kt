package bean.sample.mvvm.activity

import android.content.SharedPreferences
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

    override fun init() {
        firstViewModel.updateTodosData()
    }

    override fun initAction() {
        firstViewModel.todosDataLiveData.observe(this) { /*show data*/ }
        firstViewModel.errorLivedata.observe(this) { /*show error dialog*/ }
        firstViewModel.loadingLiveData.observe(this) {
            if (it) {
                /*show loading*/
            } else {
                /* hide loading*/
            }
        }

        binding.button2.setOnClickListener {
            sharedPreferences.edit().putString("token", "4").commit()
            firstViewModel.updateTodosData()
        }
    }

    override fun initView() {}

}