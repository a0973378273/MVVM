package bean.sample.mvvm.application

import android.app.Application
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Named

@HiltAndroidApp
class BeanApplication : Application() {

}