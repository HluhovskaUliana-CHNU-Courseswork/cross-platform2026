package ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts


import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.Result
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.map
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.requests.NewPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Post
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Posts
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.service.PostApiService
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts.PostRepository

internal class AppPostRepository(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getAllPosts(): Result<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): Result<String> {
        return postApiService.addPost(post).map {
            it.toString()
        }
    }

    override suspend fun updatePost(post: Post): Result<String> {
        return postApiService.updatePost(post).map {
            it.toString()
        }
    }

    override suspend fun deletePost(postId: Int): Result<String> {
        return postApiService.deletePost(postId).map {
            it.toString()
        }
    }
}