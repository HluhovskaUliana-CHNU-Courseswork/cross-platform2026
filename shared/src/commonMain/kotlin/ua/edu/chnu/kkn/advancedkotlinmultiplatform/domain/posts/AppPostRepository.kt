package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.NetworkResult
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.PostApiService
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.requests.NewPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.DeletedPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Post
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Posts

internal class AppPostRepository(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getAllPosts(): NetworkResult<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): NetworkResult<Post> {
        return postApiService.addPost(post)
    }

    override suspend fun updatePost(post: Post): NetworkResult<Post> {
        return postApiService.updatePost(post)
    }

    override suspend fun deletePost(postId: Int): NetworkResult<DeletedPost> {
        return postApiService.deletePost(postId)
    }
}
