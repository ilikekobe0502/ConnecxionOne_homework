package com.example.homework

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.homework.App.Companion.instance
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

inline fun <reified T : Activity> T.openBrowser(url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

inline fun <reified T : Fragment> T.withBundleValue(argsBuilder: Bundle.() -> Unit):
        T = this.apply { arguments = Bundle().apply(argsBuilder) }

inline fun <reified T : Any> Fragment.getBundleValue(key: String, default: T) = lazy {
    arguments?.get(key) as? T ?: default
}

fun ImageView.load(url: String) = Picasso.get().load(url).into(this)

//fun AppCompatActivity.changeFragment(fragment: Fragment) =
//    changeFragment(R.id.content_view, fragment)
//
//fun AppCompatActivity.changeFragment(container: Int = R.id.content_view, fragment: Fragment) {
//    supportFragmentManager.commit(true) {
//        replace(container, fragment)
//    }
//}
//
//fun AppCompatActivity.addFragment(fragment: Fragment) {
//    addFragment(R.id.content_view, fragment)
//}
//
//fun AppCompatActivity.addFragment(container: Int = R.id.content_view, fragment: Fragment) {
//    supportFragmentManager.commit(true) {
//        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        addToBackStack(null)
//        add(container, fragment)
//    }
//}

inline fun <reified T> Gson.fromJson(json: String): T =
    fromJson(json, object : TypeToken<T>() {}.type)


fun getStatusBarHeight(): Int {
    var result = 0
    //获取状态栏高度的资源id
    val resourceId = instance.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = instance.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun ImageView.loadUrl(url: String) = Picasso.get().load(url).into(this)