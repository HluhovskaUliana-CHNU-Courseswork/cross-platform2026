package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.NetworkResult
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.requests.NewPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.DeletedPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Post
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Posts

internal interface PostRepository {
    suspend fun getAllPosts(): NetworkResult<Posts>
    suspend fun addPost(post: NewPost): NetworkResult<Post>
    suspend fun updatePost(post: Post): NetworkResult<Post>
    suspend fun deletePost(postId: Int): NetworkResult<DeletedPost>
}
