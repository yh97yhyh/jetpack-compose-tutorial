package ai.alphacode.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ai.alphacode.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantView()
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ComposeQuadrantBox(title: String, detail: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = detail
        )
    }
}

@Composable
fun ComposeQuadrantView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .background(colorResource(id = R.color.purple1))
        ) {
            ComposeQuadrantBox(
                title = stringResource(id = R.string.compose_quadrant_title1_text),
                detail = stringResource(id = R.string.compose_quadrant_detail1_text)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .background(colorResource(id = R.color.purple2))
                .align(Alignment.TopEnd)
        ) {
            ComposeQuadrantBox(
                title = stringResource(id = R.string.compose_quadrant_title2_text),
                detail = stringResource(id = R.string.compose_quadrant_detail2_text)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .background(colorResource(id = R.color.purple3))
                .align(Alignment.BottomStart)
        ) {
            ComposeQuadrantBox(
                title = stringResource(id = R.string.compose_quadrant_title3_text),
                detail = stringResource(id = R.string.compose_quadrant_detail3_text)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .background(colorResource(id = R.color.purple4))
                .align(Alignment.BottomEnd)
        ) {
            ComposeQuadrantBox(
                title = stringResource(id = R.string.compose_quadrant_title4_text),
                detail = stringResource(id = R.string.compose_quadrant_detail4_text)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview")
@Composable
fun GreetingPreview2() {
    HappyBirthdayTheme {
        ComposeQuadrantView()
    }
}