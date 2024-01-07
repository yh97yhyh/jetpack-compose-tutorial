package ai.alphacode.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ai.alphacode.lemonade.ui.theme.LemonadeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                MainView(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp))
            }
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    var step by remember {
        mutableStateOf(1)
    }

    var squeeze by remember {
        mutableStateOf(1)
    }
    var squeezeCount = 0

    var stepImage = R.drawable.lemon_tree
    var stepDescription = R.string.description1_text
    var detailText = R.string.detail1_text

    when (step) {
        1 -> {
            stepImage = R.drawable.lemon_tree
            stepDescription = R.string.description1_text
            detailText = R.string.detail1_text
        }
        2 -> {
            stepImage = R.drawable.lemon_squeeze
            stepDescription = R.string.description2_text
            detailText = R.string.detail2_text
        }
        3 -> {
            stepImage = R.drawable.lemon_drink
            stepDescription = R.string.description3_text
            detailText = R.string.detail3_text
        }
        4 -> {
            stepImage = R.drawable.lemon_restart
            stepDescription = R.string.description4_text
            detailText = R.string.detail4_text
        }
        else -> {
            stepImage = R.drawable.lemon_tree
            stepDescription = R.string.description1_text
            detailText = R.string.detail1_text
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(width = 200.dp, height = 200.dp)
                .background(
                    color = colorResource(id = R.color.white_green),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = stepImage),
                contentDescription = stringResource(id = stepDescription),
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp)
                    .clickable {
                        when(step) {
                            1 -> {
                                squeeze = (2..4).random()
                                step++
                            }
                            2 -> {
                                squeezeCount++
                                if (squeeze == squeezeCount) {
                                    squeezeCount = 0
                                    step++
                                }
                            }
                            3 -> {
                                step++
                            }
                            4 -> {
                                step = 1
                            }
                        }
                    }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = detailText),
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "MainActivity")
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        MainView(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))
    }
}