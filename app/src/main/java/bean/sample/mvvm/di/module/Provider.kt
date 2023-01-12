package bean.sample.mvvm.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import bean.sample.mvvm.datalayer.retrofit.api.Api
import bean.sample.mvvm.datalayer.room.database.RoomSampleDatabase
import bean.sample.mvvm.datalayer.retrofit.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Provider {

    @Singleton
    @Provides
    fun getApi(retrofit: Retrofit): Api = retrofit.getRetrofitApiService(Api::class.java)

    @Singleton
    @Provides
    fun getSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("mvvm", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): RoomSampleDatabase =
        Room.databaseBuilder(context.applicationContext, RoomSampleDatabase::class.java, "todos.db")
            .build()

}