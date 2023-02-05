package `in`.tutorial.jetpacknavigation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import `in`.tutorial.jetpacknavigation.model.DogBreed

class DetailsViewModel:ViewModel() {
    val dogDetails = MutableLiveData<DogBreed>()
    fun fetch(){
        val dog1 = DogBreed("1", "Corgi","15 years",
            "breedGroup", "bredFor","temperament", "")
        val dog2 = DogBreed("2", "Labrador","1 years",
            "breedGroup", "bredFor","temperament", "")
        val dog3 = DogBreed("1", "Rotwiller","20 years",
            "breedGroup", "bredFor","temperament", "")
        dogDetails.value = dog1
    }
}