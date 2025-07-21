package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.application.ui.theme.ApplicationTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.compose.ui.unit.TextStyle
//import androidx.compose.ui.unit.toDp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle


class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(
                        name = "Data",
                        function = "More",
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(17.dp)
                    )
                }
            }
        }
    }
}

val pingFangFont=FontFamily(
    Font(R.font.pingfangsc_regular, weight=FontWeight.Normal),
    Font(R.font.pingfangsc_medium, weight=FontWeight.Medium)
)

//@Composable
//fun pxToDp(px:Float):Dp{
    //val density = LocalDensity.current.density
    //return Dp(px / density)
//}

//@Composable
//fun pxToSp(px:Float):TextUnit{
    //val scaledDensity = LocalDensity.current.fontScale
    //return (px / scaledDensity).sp
//}

@Composable
fun Screen(
    name:String,
    function:String?,
    modifier:Modifier=Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1B1D))
            .padding(vertical = 8.dp)
    )
    {
        Row(
            modifier = Modifier
                .width(375.dp)
                .height(44.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(!function.isNullOrBlank()) {
                Text(
                    text = name,
                    modifier = Modifier.offset(x = 12.dp),
                    style = TextStyle(
                        //fontWeight=FontWeight.Medium,
                        fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if(!function.isNullOrBlank()) {
                Text(
                    text = function,
                    //modifier = Modifier.offset(x=324.dp),
                    style = TextStyle(
                        fontFamily = pingFangFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        color = Color(0xFF808595)
                    )
                )
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Chevron Right",
                //modifier=Modifier.offset(x=pxToDp(355.3f)),
                tint = Color(0xFF808595)
            )
        }
        //Spacer(modifier = Modifier.height(213.dp))


        Row(
            modifier = Modifier
                .width(375.dp)
                .height(44.dp)
                .background(Color(0xFF1A1B1D)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(!function.isNullOrBlank()) {
                Text(
                    text = name,
                    modifier = Modifier.offset(x = 12.dp),
                    style = TextStyle(
                        //fontWeight=FontWeight.Medium,
                        fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if(!function.isNullOrBlank()) {
                Text(
                    text = function,
                    //modifier = Modifier.offset(x=324.dp),
                    style = TextStyle(
                        fontFamily = pingFangFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        color = Color(0xFF808595)
                    )
                )
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Chevron Right",
                //modifier=Modifier.offset(x=pxToDp(355.3f)),
                tint = Color(0xFF808595)
            )
        }

        Row(
            modifier = Modifier
                .width(375.dp)
                .height(44.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ApplicationTheme {
        Screen(
            name="数据中心",
            function="更多"
        )
    }
}