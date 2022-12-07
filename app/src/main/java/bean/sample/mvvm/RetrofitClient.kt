package bean.sample.mvvm

import priv.jb.base.util.BaseRetrofitClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Retrofit @Inject constructor() : BaseRetrofitClient() {
    private val domain: String
        get() {
            return if (BuildConfig.DEBUG)
                "https://jsonplaceholder.typicode.com"
            else
                "https://jsonplaceholder.typicode.com/debug"
        }

    override fun setBaseUrl(): String = domain

    override fun setHeader(): Map<String, String>? = null

    override fun setShowHttpLogging(): Boolean = BuildConfig.DEBUG
}