package com.example.androidarticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidarticle.ui.theme.AndroidArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        "Jetpack Compose Tutorial",
                        "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
                    )
                }
            }
        }
    }
}

@Composable
fun Article(nameArticle: String, paragraphOne : String , paragraphTwo : String , modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ){
        topbarImage()
        TextArticle(nameArticle = nameArticle, paragraphOne = paragraphOne, paragraphTwo = paragraphTwo, modifier = modifier)
    }
}

@Composable
fun TextArticle(nameArticle: String , paragraphOne : String ,paragraphTwo: String ,modifier: Modifier){
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(20.dp)
    ){
        Text(
            text = "Hello $nameArticle!",
            fontSize = 20.sp,
            color = Color(125,242,150),
            modifier = modifier
                .padding(
                    vertical = 10.dp
                )
        )
        Text(
            text = "$paragraphOne",
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    vertical = 10.dp
                )
        )
        Text(
            text = "$paragraphTwo",
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    vertical = 10.dp
                )
        )
    }
}

@Composable
fun topbarImage (modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidArticleTheme {
        Article("Android","some text" , "some text")
    }
}