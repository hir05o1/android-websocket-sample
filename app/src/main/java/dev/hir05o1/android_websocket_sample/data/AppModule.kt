package dev.hir05o1.android_websocket_sample.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().pingInterval(15, TimeUnit.SECONDS)  // 15 秒ごとに Ping
            .build()

    @Provides
    @Singleton
    fun provideWebSocketServiceImpl(
        client: OkHttpClient,
    ) = WebSocketListenerImpl(client)
}
