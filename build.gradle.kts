// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.53.1" apply false
    id("androidx.navigation.safeargs") version "2.8.6" apply false
    id("com.android.library") version "8.8.0" apply false
    id("com.google.devtools.ksp") version "2.1.0-1.0.29" apply false
}