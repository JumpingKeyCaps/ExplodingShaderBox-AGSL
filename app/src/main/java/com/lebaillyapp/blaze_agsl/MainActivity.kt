package com.lebaillyapp.blaze_agsl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.lebaillyapp.blaze_agsl.ui.composition.ExplodableBoxDemo
import com.lebaillyapp.blaze_agsl.ui.theme.BlazeAGSLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlazeAGSLTheme {
                ExplodableBoxDemo()
            }
        }
    }
}
