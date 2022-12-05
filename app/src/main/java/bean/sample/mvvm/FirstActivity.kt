package bean.sample.mvvm

import androidx.activity.viewModels
import bean.sample.mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import priv.jb.base.basic.BaseActivity

@AndroidEntryPoint
class FirstActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: CoroutineViewModel by viewModels()

    override fun init() {
        viewModel.runMutex()
    }

    override fun initAction() {
    }

    override fun initView() {
    }
}