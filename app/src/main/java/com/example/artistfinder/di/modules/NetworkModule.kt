package com.example.artistfinder.di.modules

import android.content.Context
import com.example.artistfinder.R
import com.example.artistfinder.model.remote.NetworkService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply{
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun providesCache(context: Context) : Cache {
        val cacheSize = 1 * 1024 * 1024 //1MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor : HttpLoggingInterceptor,
                          cache: Cache) : OkHttpClient{
        return OkHttpClient.Builder()
            .cache(cache)
            .readTimeout(10000, TimeUnit.MILLISECONDS)
            .writeTimeout(10000, TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)
//            .addInterceptor(object : Interceptor {
//                @Throws(IOException::class)
//                override fun intercept(chain: Interceptor.Chain): Response {
//                    val original = chain.request()
//                    val requestBuilder = original.newBuilder()
//                    val request = requestBuilder.build()
//                    return chain.proceed(request)
//                }
//            })
            .build()
    }

    @Provides
    @Singleton
    fun providesRxJava2CallAdapter() : RxJava2CallAdapterFactory{
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun providesGson(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        gsonConverterFactory: GsonConverterFactory,
        context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.resources.getString(R.string.itunes_base_url))
            .client(okHttpClient)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }


    @Provides
    fun providesNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

}