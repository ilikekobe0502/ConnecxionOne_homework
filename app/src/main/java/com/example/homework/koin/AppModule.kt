package com.example.homework.koin

import com.example.homework.network.UnsafeSSLConnection
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {

}

inline fun <reified T> provideApi(client: OkHttpClient, url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(T::class.java)
}

val networkModule = module {
    // OkHttpClient
    single {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .callTimeout(15, TimeUnit.SECONDS)
        UnsafeSSLConnection.setSslSocketFactory(builder)
        builder.build()
    }
}

val repositoryModule = module {

}

val dbModule = module {
}

val appModule = listOf(dbModule, repositoryModule, networkModule, viewModelModule)