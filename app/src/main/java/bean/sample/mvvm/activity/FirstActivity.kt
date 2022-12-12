package bean.sample.mvvm.activity

import android.content.SharedPreferences
import android.util.Log
import androidx.activity.viewModels
import bean.sample.mvvm.viewmodel.CoroutineViewModel
import bean.sample.mvvm.viewmodel.FirstViewModel
import bean.sample.mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import priv.jb.base.basic.BaseActivity
import priv.jb.base.data.DataStatus
import javax.inject.Inject

@AndroidEntryPoint
class FirstActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: CoroutineViewModel by viewModels()
    private val firstViewModel: FirstViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun init() {
        firstViewModel.updateTodosData()
    }

    override fun initAction() {
        firstViewModel.TodosDataLiveData.observe(this) {
            when (it) {
                is DataStatus.Finish -> {
                    Log.d("test", "Finish $it")
                }
                is DataStatus.Error -> {
                    Log.d("test", "Error ${it.code} : ${it.message}")
                }
                is DataStatus.Connect -> {
                    Log.d("test", "Connect $it")
                }
            }
        }

        binding.button2.setOnClickListener {
            sharedPreferences.edit().putString("token", "4").commit()
            firstViewModel.updateTodosData()
        }
    }

    override fun initView() {}

}