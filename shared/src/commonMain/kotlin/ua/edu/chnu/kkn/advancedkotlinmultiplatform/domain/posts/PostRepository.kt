package ua.edu.chnu.kkn.advancedkotlinmultiplatform.domain.posts

import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.common.Result
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.requests.NewPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.DeletedPost
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Post
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses.Posts

internal interface PostRepository {
    suspend fun getAllPosts(): Result<Posts>
    suspend fun addPost(post: NewPost): Result<String>
    suspend fun updatePost(post: Post): Result<String>
    suspend fun deletePost(postId: Int): Result<String>
}
