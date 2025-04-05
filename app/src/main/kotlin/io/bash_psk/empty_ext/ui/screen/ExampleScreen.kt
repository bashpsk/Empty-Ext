package io.bash_psk.empty_ext.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.bash_psk.empty_ext.apps.appLinkShare
import io.bash_psk.empty_ext.apps.appOpenGooglePlay
import io.bash_psk.empty_ext.apps.getAppVersion
import io.bash_psk.empty_ext.link.linkOpenBrowser
import io.bash_psk.empty_ext.log.SetLog
import io.bash_psk.empty_ext.mail.sendEmail
import io.bash_psk.empty_ext.toast.toastShort
import java.io.IOException

@Composable
fun ExampleScreen() {

    val content = LocalContext.current

    val appVersion = remember { getAppVersion(context = content) }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("App Version : ${appVersion.name}, ${appVersion.number}")

            Button(
                onClick = {

                    try {

                        throw IOException("This Test Exception From PSK!")
                    } catch (exception: Exception) {

                        exception.message?.toastShort(context = content)
                        SetLog.error(tag = "EMPTY-EXT", throwable = exception)
                    }
                }
            ) {

                Text("Try Exception")
            }

            Button(
                onClick = {

                    appLinkShare(
                        context = content,
                        appPackage = "io.bash_psk.tetris",
                        message = "Try My Game. A/v on Google Play. Link :"
                    )
                }
            ) {

                Text("Share App")
            }

            Button(
                onClick = {

                    appOpenGooglePlay(context = content, appPackage = "io.bash_psk.tetris")
                }
            ) {

                Text("Open App Google Play")
            }

            Button(
                onClick = {

                    linkOpenBrowser(context = content, link = "https://www.google.co.in/")
                }
            ) {

                Text("Open Link In Browser")
            }

            Button(
                onClick = {

                    sendEmail(
                        context = content,
                        email = "test123@gmail.com",
                        subject = "Demo",
                        body = "This demo mail, from Bash PSK."
                    )
                }
            ) {

                Text("Open Mail")
            }
        }
    }
}