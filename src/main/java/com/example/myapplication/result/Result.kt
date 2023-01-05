package com.example.myapplication.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Result(
    var voie: String?,
    var numero: String?,
    var type: String?,
    var surface: String?,
    var Piece: String?
) : Parcelable

