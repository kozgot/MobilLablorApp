package com.example.mobillaborapp.mock.network

import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.model.network.UploadResponse
import com.example.mobillaborapp.repository.network.CatAPI
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import kotlin.collections.ArrayList

class MockCatAPI : CatAPI {
    override fun listOwnImages(xApiKey: String, limit: Int?, page: Int?): Call<ArrayList<Image>> {
        val images = ArrayList<Image>()
        var breeds = mutableListOf<Breed>()
        breeds.add(Breed( "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3))
        images.add(Image(breeds,"2u0QIn3hP", "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg",
            3648, 2736, null, "2021-05-01T17:16:36.000Z", "IMG_20210428_204622.jpg", "bamb"))

        val call = object : Call<ArrayList<Image>> {
            @Throws(IOException::class)
            override fun execute(): Response<ArrayList<Image>> {
                return Response.success(images)
            }

            override fun enqueue(callback: Callback<ArrayList<Image>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ArrayList<Image>> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun listBreeds(xApiKey: String): Call<ArrayList<Breed>> {
        var breeds = ArrayList<Breed>()
        breeds.add(Breed( "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3))

        val call = object : Call<ArrayList<Breed>> {
            @Throws(IOException::class)
            override fun execute(): Response<ArrayList<Breed>> {
                return Response.success(breeds)
            }

            override fun enqueue(callback: Callback<ArrayList<Breed>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ArrayList<Breed>> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun listPublicImages(xApiKey: String, limit: Int?, page: Int?): Call<ArrayList<Image>> {
        val images = ArrayList<Image>()
        var breeds = mutableListOf<Breed>()
        breeds.add(Breed( "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3))
        images.add(Image(breeds,"2u0QIn3hP", "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg",
            3648, 2736, null, "2021-05-01T17:16:36.000Z", "IMG_20210428_204622.jpg", "bamb"))


        val call = object : Call<ArrayList<Image>> {
            @Throws(IOException::class)
            override fun execute(): Response<ArrayList<Image>> {
                return Response.success(images)
            }

            override fun enqueue(callback: Callback<ArrayList<Image>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ArrayList<Image>> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun uploadImage(file: MultipartBody.Part, xApiKey: String, breedIds: RequestBody?): Call<UploadResponse> {
        val response = UploadResponse()
        response.approved = 1
        response.height = 2736
        response.width = 3648
        response.url = "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg"
        response.originalFilename = "IMG_20210428_204622.jpg"
        response.id = "2u0QIn3hP"
        response.pending = 0

        val call = object : Call<UploadResponse> {
            @Throws(IOException::class)
            override fun execute(): Response<UploadResponse> {
                return Response.success(response)
            }

            override fun enqueue(callback: Callback<UploadResponse>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<UploadResponse> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun getImage(imageId: String, xApiKey: String): Call<Image> {
        var breeds = mutableListOf<Breed>()
        breeds.add(Breed( "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3))
        val image = Image(breeds,"2u0QIn3hP", "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg",
            3648, 2736, null, "2021-05-01T17:16:36.000Z", "IMG_20210428_204622.jpg", "bamb")

        val call = object : Call<Image> {
            @Throws(IOException::class)
            override fun execute(): Response<Image> {
                return Response.success(image)
            }

            override fun enqueue(callback: Callback<Image>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Image> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun deleteImage(imageId: String, xApiKey: String): Call<Void> {
        val call = object : Call<Void> {
            @Throws(IOException::class)
            override fun execute(): Response<Void> {
                return Response.success(null)
            }

            override fun enqueue(callback: Callback<Void>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Void> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }
}