package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.remove

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.Result
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.PostRepository

internal class RemovePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Int): Result<String> {
        return postRepository.deletePost(postId)
    }
}