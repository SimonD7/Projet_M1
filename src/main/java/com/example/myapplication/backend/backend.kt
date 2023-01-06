package com.example.myapplication.backend


class backend{

    private val A = listOf(-1.53420471e+01, 3.40492965e+05, 1.10834777e+03, 2.35916834e+03, 8.60752762e+01, 6.63519570e+05, 1.20224955e+06)
    private val B = -60074359.051963925

    fun estimation(adresse_numero: Int, type_local: String, surface_reelle_bati: Int, nombre_pieces_principales: Int, surface_terrain: Int, longitude: Double, latitude: Double): Double {
        var typeLocal = 0
        if (type_local == "Maison") {
            typeLocal = 0
        } else if (type_local == "Appartement") {
            typeLocal = 1
        }
        val f = B  + A[0] * adresse_numero + A[1] * typeLocal + A[2] * surface_reelle_bati + A[3] * nombre_pieces_principales + A[4] * surface_terrain + A[5] * longitude + A[6] * latitude
        return f
    }


}


