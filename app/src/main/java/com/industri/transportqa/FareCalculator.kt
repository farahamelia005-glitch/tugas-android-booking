package com.industri.transportqa

class FareCalculator {

    // Validasi NIK Penumpang Wajib 16 Karakter Angka
    fun isValidNik(nik: String): Boolean {
        if (nik.length != 16) return false
        return nik.all { it.isDigit() }
    }

    // Kalkulasi Total Tarif Tiket Berdasarkan Kategori Penumpang & Bagasi
    fun calculateTotalFare(
        baseFare: Double,
        passengerAge: Int,
        baggageWeightKg: Int
    ): Double {

        if (baseFare < 0) {
            throw IllegalArgumentException("Tarif dasar tidak boleh minus")
        }

        if (passengerAge < 0) {
            throw IllegalArgumentException("Usia tidak valid")
        }

        // Diskon usia:
        // Balita (< 3 tahun) = 100%
        // Lansia (>= 60 tahun) = 20%
        val discountRate = when {
            passengerAge < 3 -> 1.0
            passengerAge >= 60 -> 0.20
            else -> 0.0
        }

        val fareAfterDiscount = baseFare * (1.0 - discountRate)

        // Bagasi gratis sampai 20 kg
        // Kelebihan = Rp25.000/kg
        val excessBaggageKg =
            if (baggageWeightKg > 20) baggageWeightKg - 20 else 0

        val baggageFee = excessBaggageKg * 25000.0

        return fareAfterDiscount + baggageFee
    }
}