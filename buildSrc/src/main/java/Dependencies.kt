object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0"

    const val coil = "io.coil-kt:coil:0.7.0"

    const val junit = "junit:junit:4.12"

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.1.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Lifecycle {
            private const val version = "2.1.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Room {
            private const val version = "2.2.0-rc01"
            const val runtime = "androidx.room:room-runtime:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }

        object WorkManager {
            private const val version = "2.2.0"
            const val ktx = "androidx.work:work-runtime-ktx:$version"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.1.0-alpha10"
    }

    object Kotlin {
        private const val version = "1.3.41"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Coroutines {
        private const val version = "1.3.0"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Retrofit {
        private const val version = "2.6.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.1.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Koin {
        private const val version = "2.0.1"
        const val koin = "org.koin:koin-android:$version"
        const val viewmodel = "org.koin:koin-android-viewmodel:$version"
    }

    object Test {
        private const val version = "1.2.0"
        const val runner = "androidx.test:runner:$version"

        const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
    }

}