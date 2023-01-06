package com.example.myapplication.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/***
 * cette classe permet de stocker tout les valeur a la fois .
 */
@Parcelize
class Result(
    var longitude: Double?,
    var latitude: Double?,
    var numero: Int?,
    var type: String?,
    var surfacet: Int?,
    var Piece: Int?,
    var surfaceb: Int?
) : Parcelable

