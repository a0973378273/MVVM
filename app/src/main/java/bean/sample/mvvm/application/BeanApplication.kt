package bean.sample.mvvm.application

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Named

@HiltAndroidApp
class BeanApplication : Application() {
    private val TAG = "test"

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener {
            if (it.isComplete){
                val token = it.result
//                val message = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, "getToken: $token")
            }
        }
    }
}