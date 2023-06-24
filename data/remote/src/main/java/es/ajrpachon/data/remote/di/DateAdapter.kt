package es.ajrpachon.data.remote.di

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class DateAdapter {

    private val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    @ToJson
    fun toJson(value: Date): String {
        return df.format(value)
    }

    @FromJson
    fun fromJson(source: String): Date {
        return df.parse(source)
    }
}