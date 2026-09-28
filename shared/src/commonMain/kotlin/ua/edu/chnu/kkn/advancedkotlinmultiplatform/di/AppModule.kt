package ua.edu.chnu.kkn.advancedkotlinmultiplatform.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.service.AppPostApiService
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.service.PostApiService
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.AppPostRepository
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.PostRepository
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.create.CreatePostUseCase
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.edit.EditPostUseCase
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.obtain.ObtainPostsUseCase
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.remove.RemovePostUseCase
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.presentation.AppViewModel

val networkModule = module {
    single {
        HttpClient {
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println("KtorLogger: $message")
                    }
                }
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    singleOf(::AppPostApiService) { bind<PostApiService>() }
}
val appModule = module {
    includes(networkModule)
    singleOf(::AppPostRepository) { bind<PostRepository>() }
    factoryOf(::CreatePostUseCase)
    factoryOf(::EditPostUseCase)
    factoryOf(::ObtainPostsUseCase)
    factoryOf(::RemovePostUseCase)
    viewModelOf(::AppViewModel)
}