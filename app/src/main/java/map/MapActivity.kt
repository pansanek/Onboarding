package map

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import ru.thekodingklowns.onboarding.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mxalbert.sharedelements.SharedElementsRoot
import ru.thekodingklowns.onboarding.presentation.OnboardingApp
import ru.thekodingklowns.onboarding.presentation.navigation.LocalNavController
import ru.thekodingklowns.onboarding.presentation.theme.OnboardingTheme

class MapActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageZoom()
                }
            }
        }
    }
}
@Preview
@Composable
fun ImageZoom(){
    var scale by remember{
        mutableStateOf(1f)
    }

    Column(modifier = Modifier.fillMaxSize()){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            Text(text="Карта офиса", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(RectangleShape)
            .pointerInput(Unit) {
                detectTransformGestures { _, _, zoom, _ ->
                    scale *= zoom
                }

            }
        ){
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.image_1), contentDescription = "Image",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = maxOf(.10f, minOf(10f, scale)),
                    scaleY = maxOf(.10f, minOf(10f, scale)),
                ))
        }
    }

}