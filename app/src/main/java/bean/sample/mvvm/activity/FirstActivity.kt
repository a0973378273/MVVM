package bean.sample.mvvm.activity

import androidx.activity.viewModels
import bean.sample.mvvm.CoroutineViewModel
import bean.sample.mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import priv.jb.base.basic.BaseActivity
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class FirstActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: CoroutineViewModel by viewModels()

    @Inject
    @Named("Name")
    lateinit var named: String

    override fun init() {
//        viewModel.runMutex()
//        println("FirstActivity start $named ${Thread.currentThread()}")
//        viewModel.runBlocking()
//        println("FirstActivity end ${Thread.currentThread()}")

    }

    override fun initAction() {
    }

    override fun initView() {
    }

}