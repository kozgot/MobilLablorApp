package com.example.mobillaborapp.mock.network

import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.model.UploadResponse
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
        val image = Image()
        image.url = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
        image.width = 1204
        image.height = 1445

        // todo: fill other props?

        images.add(image)

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
        val breeds = ArrayList<Breed>()
        val breed = Breed()
        breed.id = "abys"
        breed.name = "Abyssinian"
        breed.origin = "Egypt"
        breed.description = "The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals."
        // todo: fill other props?

        breeds.add(breed)

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
        val image = Image()
        image.url = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
        image.width = 1204
        image.height = 1445

        // todo: fill other props?

        images.add(image)

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
        response.height = 600
        response.width = 1200
        response.url = "https://cdn2.thecatapi.com/images/swnBdcpjb.png"
        response.originalFilename = "Thinking-of-getting-a-cat.png"
        response.id = "swnBdcpjb"
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
        val image = Image()
        image.url = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
        image.width = 1204
        image.height = 1445
        // todo: fill other props?

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