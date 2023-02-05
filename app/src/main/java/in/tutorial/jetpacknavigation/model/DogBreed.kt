package `in`.tutorial.jetpacknavigation.model

import com.google.gson.annotations.SerializedName

//https://raw.githubusercontent.com/DevTides/DogsApi/master/dogs.json
data class DogBreed (
    @SerializedName("id")
    val breedId: String?,
    @SerializedName("name")
    val dogBreed: String?,
    @SerializedName("life_span")
    val lifespan: String?,
    @SerializedName("breed_group")
    val breedGroup:String?,
    @SerializedName("bred_for")
    val bredFor:String?,
    @SerializedName("temperament")
    val temperament: String?,
    @SerializedName("url")
    val imageUrl:String?
)