package com.example.movieticketapp.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import okhttp3.Dispatcher
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseApiService<T : Any> {
    companion object {
        const val TIME_OUT = 30L
    }

    fun getService(
        context: Context,
        allowVpn: Boolean = true,
        accessToken: String? = null,
    ): T? {
        val baseUrl = getBaseUrl()

        val builder = okhttp3.OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        val okHttpClient =
            builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .dispatcher(dispatcher).apply {
                    accessToken?.let {
                        addInterceptor {
                            it.proceed(
                                it.request().newBuilder()
                                    .addHeader("Authorization", "Bearer $accessToken")
                                    .build(),
                            )
                        }
                    }
                }
                .build()

        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: Network? = connectivityManager.activeNetwork
        val caps: NetworkCapabilities? =
            connectivityManager.getNetworkCapabilities(activeNetwork)
        val vpnInUse = caps?.hasTransport(NetworkCapabilities.TRANSPORT_VPN) ?: false
        return if (!vpnInUse || allowVpn) (retrofit.create(getApiService()) as T) else null
    }

    abstract fun getBaseUrl(): String

    abstract fun getApiService(): Class<*>
}
