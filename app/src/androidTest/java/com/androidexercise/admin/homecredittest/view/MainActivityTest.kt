package com.androidexercise.admin.homecredittest.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.androidexercise.admin.homecredittest.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewProduct() {
        Thread.sleep(2000)

        onView(withId(R.id.rv_product_grid)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_article_section)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        onView(withId(R.id.rv_product_grid)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
    }

    @Test
    fun testRecyclerViewArticle() {

        Thread.sleep(2000)
        onView(withId(R.id.rv_article_section)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_article_section)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        onView(withId(R.id.rv_article_section)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
    }

    @Test
    fun testAppBehaviour() {
        /**
         * Masuk kehalaman detail
         */
        Thread.sleep(2000)
        onView(withId(R.id.scrollView)).perform(ViewActions.swipeDown())
        onView(withId(R.id.scrollView)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rv_product_grid)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_product_grid)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        Thread.sleep(2000)
        onView(withText("Detail")).check(matches(isDisplayed()))

        onView(withId(R.id.scrollView)).perform(ViewActions.swipeDown())

        /**
         * Back ke homeActivity
         */
        pressBackUnconditionally()
    }
}