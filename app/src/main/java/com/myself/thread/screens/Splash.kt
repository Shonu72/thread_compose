package com.myself.thread.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.myself.thread.R
import com.myself.thread.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val(image) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            // center the image
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.size(120.dp),
        )
    }
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(Routes.BottomNav.routes)
    }
}
