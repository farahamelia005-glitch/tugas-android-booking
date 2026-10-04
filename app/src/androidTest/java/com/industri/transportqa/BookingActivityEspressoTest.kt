package com.industri.transportqa

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookingActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun isiFormPemesanan_danTekanPesan_harusMenampilkanKonfirmasiTiket() {

        onView(withId(R.id.etNik))
            .perform(
                typeText("3209123456780001"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.etName))
            .perform(
                typeText("Ahmad Dahlan"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.btnSubmitBooking))
            .perform(click())

        onView(withId(R.id.tvBookingStatus))
            .check(matches(isDisplayed()))
            .check(
                matches(
                    withText("Pemesanan Tiket Berhasil Diverifikasi")
                )
            )
    }

    @Test
    fun nikKosong_danTekanPesan_harusMenampilkanError() {

        onView(withId(R.id.etName))
            .perform(
                typeText("Ahmad Dahlan"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.btnSubmitBooking))
            .perform(click())

        onView(withId(R.id.etNik))
            .check(matches(hasErrorText("NIK tidak boleh kosong")))
    }
}

