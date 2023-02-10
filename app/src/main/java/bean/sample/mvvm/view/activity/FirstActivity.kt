package bean.sample.mvvm.view.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
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

    override fun init() {

        firstViewModel.updateTodosData()
        firstViewModel.getDB()
        firstViewModel.setDB()
        firstViewModel.getDB()
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