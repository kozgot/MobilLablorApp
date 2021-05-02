package com.example.mobillaborapp.model.network

import com.google.gson.annotations.SerializedName

class Image(
        @SerializedName("breeds")
        var breeds: List<Breed> = ArrayList(),

        @SerializedName("id")
        var id: String? = null,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("width")
        var width: Int? = null,

        @SerializedName("height")
        var height: Int? = null,

        @SerializedName("sub_id")
        var subId: String? = null,

        @SerializedName("created_at")
        var createdAt: String? = null,

        @SerializedName("original_filename")
        var originalFilename: String? = null,

        @SerializedName("breed_ids")
        var breedIds: String? = null
) {
        override fun equals(other: Any?) = (other is Image) &&
                other.breeds.count() == this.breeds.count() &&
                areEqualBreedLists(other.breeds, this.breeds) &&
                other.breedIds == this.breedIds &&
                other.id == this.id &&
                other.originalFilename == this.originalFilename &&
                other.createdAt == this.createdAt &&
                other.subId == this.subId &&
                other.url == this.url &&
                other.height == this.height &&
                other.width == this.width

        private fun areEqualBreedLists(firstBreedList: List<Breed>, secondBreedList: List<Breed>): Boolean {
                if (firstBreedList.count() == 1 && secondBreedList.count() == 1) {
                        return firstBreedList[0] == secondBreedList[0]
                }

                return firstBreedList.count() == secondBreedList.count()
        }
}