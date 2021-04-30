package com.example.mobillaborapp.ui.addpicture

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.mobillaborapp.R
import com.example.mobillaborapp.injector
import com.example.mobillaborapp.ui.picturelist.ScrollingActivity
import com.example.mobillaborapp.ui.utils.getFileName
import kotlinx.android.synthetic.main.activity_add_picture.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.inject.Inject

class AddPictureActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AddPictureScreen {
    @Inject
    lateinit var addPicturePresenter: AddPicturePresenter
    private lateinit var fileToUpload:File
    private lateinit var selectedFile:Uri
    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")

    // image picker
    lateinit var imageView: ImageView
    lateinit var uploadButton: Button
    private var imageUri: Uri? = null

    val REQUEST_CODE = 100

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_picture)
        injector.inject(this)

        // breed selector
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(mySpinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@AddPictureActivity
            prompt = "Select a breed"
            gravity = Gravity.CENTER

        }

        //image picker
        title = "Add new cat pic"
        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }

        uploadButton = findViewById(R.id.buttonUploadImage)
        uploadButton.setOnClickListener {
            uploadImage()
        }
    }

    override fun onStart() {
        super.onStart()
        addPicturePresenter.attachScreen(this)
    }

    override fun onStop() {
        addPicturePresenter.detachScreen()
        super.onStop()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when (view?.id) {
            1 -> showToast(message = "Spinner 2 Position:${position} and language: ${languages[position]}")
            else -> {
                showToast(message = "Spinner 1 Position:${position} and language: ${languages[position]}")
            }
        }
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
            selectedFile = data?.data!!
            val input = contentResolver.openInputStream(selectedFile)
            fileToUpload=File.createTempFile("temp", ".jpg")
            val out = FileOutputStream(fileToUpload)
            val buf = ByteArray(1024)
            if (input != null) {
                var len= input.read(buf)
                while (len>0) {
                    out.write(buf, 0, len)
                    len=input.read(buf)

                }
                input!!.close()
            }
            out.close()
            Log.i("file" , fileToUpload.length().toString())
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun uploadImage() {
        if (imageUri == null) {
            showToast(message = "Select an image first!")
            return
        }
        progress_bar.progress = 0
        var parcelFileDescriptor = contentResolver.openFileDescriptor(imageUri!!, "r", null) ?: return
        var inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        var file = File(cacheDir, contentResolver.getFileName(imageUri!!))
        var outputStream = FileOutputStream(file)
        inputStream.copyTo(outputStream)

        progress_bar.progress = 90
        // todo breed id
        addPicturePresenter.uploadImage(file, "sibe")
    }

    override fun showResponse(response: String) {
        progress_bar.progress = 100

        val intent = Intent(this, ScrollingActivity::class.java)
        this.startActivity(intent)
        showToast(message = response)
    }
}