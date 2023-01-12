package bean.sample.mvvm.datalayer.retrofit

import android.content.SharedPreferences
import bean.sample.mvvm.BuildConfig
import priv.jb.base.util.BaseRetrofitClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Retrofit @Inject constructor(val sharedPreferences: SharedPreferences) : BaseRetrofitClient() {
    private val domain: String
        get() {
            return if (BuildConfig.DEBUG)
                "https://jsonplaceholder.typicode.com"
            else
                "https://jsonplaceholder.typicode.com"
        }

    override fun setBaseUrl(): String = domain

    override fun setHeader(): Map<String, String>? = HashMap<String,String>().apply {
        val token = sharedPreferences.getString("token","1")
        set("token",token!!)
    }

    override fun setShowHttpLogging(): Boolean = BuildConfig.DEBUG
}