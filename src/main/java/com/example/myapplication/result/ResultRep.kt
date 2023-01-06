package com.example.myapplication.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface ResultRep{
    @Parcelize
    object NotEstimed : ResultRep,Parcelable

    @JvmInline
    @Parcelize
    value class Estimed(val result : Double ) : ResultRep, Parcelable

}