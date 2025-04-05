package io.bash_psk.empty_ext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.bash_psk.empty_ext.ui.screen.ExampleScreen
import io.bash_psk.empty_ext.ui.theme.EmptyExtTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            EmptyExtTheme {

                ExampleScreen()
            }
        }
    }
}