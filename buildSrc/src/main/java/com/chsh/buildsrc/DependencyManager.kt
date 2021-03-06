package com.chsh.buildsrc

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/3
 *     desc  : 如果数量少的话，放在一个类里面就可以，如果数量多的话，可以拆分为多个类
 * </pre>
 */

object Versions {
    const val retrofit = "2.9.0"
    const val okhttpLogging = "4.9.0"
    const val appcompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val constraintlayout = "2.0.4"
    const val paging = "3.0.0"
    const val timber = "4.7.1"
    const val kotlin = "1.4.20"
    const val kotlinCoroutinesCore = "1.3.7"
    const val kotlinCoroutinesAndrid = "1.3.6"
    const val koin = "2.1.5"
    const val room = "2.3.0"
    const val cardview = "1.0.0"
    const val recyclerview = "1.0.0"
    const val activity = "1.4.0"
    const val fragment = "1.3.6"
    const val anko = "0.10.8"
    const val swiperefreshlayout = "1.1.0"
    const val junit = "4.13.1"
    const val junitExt = "1.1.2"
    const val espressoCore = "3.3.0"
    const val jDatabinding = "1.0.4"
    const val progressview = "1.0.2"
    const val runtime = "1.1.0"
    const val hit = "2.42"
    const val hitViewModule = "1.0.0-alpha01"
    const val appStartup = "1.1.1"
    const val material = "1.3.0"
    const val compose = "1.1.1"
    const val work = "2.7.1"
}

object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val workRuntime = "androidx.work:work-runtime:${Versions.work}"
    const val workTesting = "androidx.work:work-testing:${Versions.work}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val appStartup = "androidx.startup:startup-runtime:${Versions.appStartup}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
    const val work = "androidx.work:work-runtime:${Versions.work}"
    const val workKtx = "androidx.work:work-runtime-ktx:${Versions.work}"
}

object Basic {
    const val meteria = "com.google.android.material:material:${Versions.material}"
    const val gson = "com.google.code.gson:gson:2.8.6"
}

object Hilt {
    const val daggerRuntime = "com.google.dagger:hilt-android:${Versions.hit}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hit}"
    const val viewModule = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hitViewModule}"
    const val compiler = "androidx.hilt:hilt-compiler:${Versions.hitViewModule}"
    const val work = "androidx.hilt:hilt-work:1.0.0"
}

object Coil {
    const val runtime = "io.coil-kt:coil:${Versions.runtime}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
    const val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val testing = "androidx.room:room-testing:${Versions.room}"
}

object Fragment {
    const val runtime = "androidx.fragment:fragment:${Versions.fragment}"
    const val runtimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
}

object Kt {
    const val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutinesAndrid}"
    const val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Koin {
    const val core = "org.koin:koin-core:${Versions.koin}"
    const val androidCore = "org.koin:koin-android:${Versions.koin}"
    const val viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val androidScope = "org.koin:koin-android-scope:$${Versions.koin}"
}

object Anko {
    const val common = "org.jetbrains.anko:anko-common:${Versions.anko}"
    const val sqlite = "org.jetbrains.anko:anko-sqlite:${Versions.anko}"
    const val coroutines = "org.jetbrains.anko:anko-coroutines:${Versions.anko}"
    const val design = "org.jetbrains.anko:anko-design:${Versions.anko}" // For SnackBars
}

object Retrofit {
    const val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
}

object Depend {
    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val jDatabinding = "com.hi-dhl:jdatabinding:${Versions.jDatabinding}"
    const val progressview = "com.hi-dhl:progressview:${Versions.progressview}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Compose{
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiTool = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val materialExtend = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val rxjava2 = "androidx.compose.runtime:runtime-rxjava2:${Versions.compose}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    const val activity = "androidx.activity:activity-compose:1.4.0"
}

