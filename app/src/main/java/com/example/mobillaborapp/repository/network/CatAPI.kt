package com.example.mobillaborapp.repository.network

import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.model.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface CatAPI {
    /**
     * Lists all breeds.
     *
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @return Call<Breeds>
    </Breeds> */
    @GET("breeds")
    fun listBreeds(
        @Header("x-api-key") xApiKey: String
    ): Call<ArrayList<Breed>>

    /**
     * Lists your uploaded images.
     *
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @param limit
     * @param page
     * @return Call<Images>
    </Images> */
    @GET("images")
    fun listOwnImages(
        @Header("x-api-key") xApiKey: String,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?
    ): Call<ArrayList<Image>>

    /**
     * Lists all public images.
     *
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @param limit
     * @param page
     * @return Call<Images>
    </Images> */
    @GET("images/search")
    fun listPublicImages(
        @Header("x-api-key") xApiKey: String,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?
    ): Call<ArrayList<Image>>

    /**
     * Uploads a new image.
     *
     * @param file The file to upload.
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @param breedIds Optional. The id of the breed of the cat. Only one id can be added.
     * @return Call<UploadResponse>
    </UploadResponse> */
    @Multipart
    @POST("images/upload")
    fun uploadImage(
        @Part file: MultipartBody.Part,
        @Header("x-api-key") xApiKey: String,
        @Part("breed_ids") breedIds: RequestBody?
    ): Call<UploadResponse>

    /**
     * Gets an image by id.
     *
     * @param imageId
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @return Call<Image>
    </Image> */
    @GET("images/{image_id}")
    fun getImage(
        @Path("image_id") imageId: String, @Header("x-api-key") xApiKey: String
    ): Call<Image>

    /**
     * Deletes an image.
     *
     * @param imageId
     * @param xApiKey Generated header parameter. Example value =&#39;16d40230-356f-4ee1-83ab-b3b9189b52f4&#39;
     * @return Call<Void>
    </Void> */
    @DELETE("images/{image_id}")
    fun deleteImage(
        @Path("image_id") imageId: String, @Header("x-api-key") xApiKey: String
    ): Call<Void>
}