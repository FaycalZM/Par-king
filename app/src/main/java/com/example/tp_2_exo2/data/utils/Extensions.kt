package com.example.tp_2_exo2.data.utils

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.InputStream

private fun openImagePicker(launcher: ActivityResultLauncher<Intent>) {
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    launcher.launch(intent)
}

fun createPartFromString(stringData: String): RequestBody {
    return stringData.toRequestBody("text/plain".toMediaTypeOrNull())
}

fun getRealPathFromURI(context: Context, contentUri: Uri?): String? {
    var cursor: Cursor? = null
    return try {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        cursor = context.contentResolver.query(contentUri!!, proj, null, null, null)
        val column_index = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor?.moveToFirst()
        cursor?.getString(column_index ?: 0)
    } finally {
        cursor?.close()
    }
}

fun prepareFilePart(partName: String, fileUri: Uri?, context: Context): MultipartBody.Part? {
    val filePath = getRealPathFromURI(context, fileUri)
    filePath?.let {
        val file = File(it)
        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }
    return null
}

fun createRequestBodyFromUri(context: Context, uri: Uri): RequestBody? {
    return try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        inputStream?.let {
            val byteArray = it.readBytes()
            byteArray.toRequestBody("image/*".toMediaTypeOrNull())
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun splitLatLong(latLong: String): Pair<Double, Double> {
    val parts = latLong.split(",")
    if (parts.size != 2) {
        throw IllegalArgumentException("Input string is not in the correct format: $latLong")
    }
    val latitude = parts[0].trim().toDoubleOrNull()
    val longitude = parts[1].trim().toDoubleOrNull()

    if (latitude == null || longitude == null) {
        throw IllegalArgumentException("Latitude or longitude is not a valid number: $latLong")
    }

    return Pair(latitude, longitude)
}