package ua.edu.chnu.kkn.advancedkotlinmultiplatform.data.posts.model.responses

import kotlinx.serialization.Serializable

@Serializable
internal data class Reactions(
    val dislikes: Int = 0,
    val likes: Int = 0
)
