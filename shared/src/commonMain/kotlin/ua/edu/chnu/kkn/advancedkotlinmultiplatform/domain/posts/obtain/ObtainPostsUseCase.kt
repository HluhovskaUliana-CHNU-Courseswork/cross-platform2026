package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.obtain

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.Result
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Posts
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.PostRepository

internal class ObtainPostsUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(): Result<Posts> {
        return postRepository.getAllPosts()
    }
}