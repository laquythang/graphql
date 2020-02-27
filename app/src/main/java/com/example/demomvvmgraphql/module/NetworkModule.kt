package com.example.demomvvmgraphql.module

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.example.demomvvmgraphql.BuildConfig
import com.example.demomvvmgraphql.network.ApiService
import com.example.demomvvmgraphql.util.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.e("Tag", "\n" + message)
                }

            })
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }
        return client.build()
    }

    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(apolloClient: ApolloClient): ApiService {
        return ApiService(apolloClient)
    }

}