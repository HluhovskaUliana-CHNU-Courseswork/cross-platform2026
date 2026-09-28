package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.create

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.Result
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.requests.NewPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.PostRepository

internal class CreatePostUseCase (
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(post: NewPost): Result<String> {
        return postRepository.addPost(post)
    }
}