package com.example.myapplication

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
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.compose.ui.unit.TextStyle
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopBar(
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

@Composable
fun TopBar(
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
            if (!function.isNullOrBlank()) {
                Text(
                    text = name,
                    modifier = Modifier.offset(x = 12.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (!function.isNullOrBlank()) {
                Text(
                    text = function,
                    //modifier = Modifier.offset(x=324.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
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
            if (!function.isNullOrBlank()) {
                Text(
                    text = name,
                    modifier = Modifier.offset(x = 12.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (!function.isNullOrBlank()) {
                Text(
                    text = function,
                    //modifier = Modifier.offset(x=324.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
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
    }
}

@Composable
fun Function(
    image: Painter,
    label: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{onClick()}
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier=Modifier
                .width(36.dp)
                .clickable{onClick()}
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.rectangle),
                contentDescription = label,
                modifier = Modifier
                    .padding(top=10.5.dp)
                    .size(36.dp)
                    .offset(x=25.5.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = label,
                fontSize = 13.sp,
                color = Color(0xFF333333),
                modifier=Modifier
                    .offset(x=30.5.dp)
                    .padding(bottom=20.dp)
            )
        }
    }
}

//@Composable
//fun FunctionGrid(){
    //val labels=listOf(
        //Pair("https://ikh.gtja.com/open/account/index.html?tjrId=320751&webViewType=1&useSafari=1", "开户"),
        //Pair("https://n.sinaimg.cn/client/216/w108h108/20210419/59d0-knvsnuh5943640.png","新股新债"),
        //Pair("","选股"),
        //"产业链",
        //Pair("""龙虎榜",
        //Pair("https://n.sinaimg.cn/client/216/w108h108/20210416/9a2c-knvsnuf5569249.png", "决策商城"),
        //Pair("https://n.sinaimg.cn/client/216/w108h108/20240307/61d5-9bc7d8a7db3cb76af1655a68d9aa8d12.png", "业绩大全"),
        //"机构调研",
        //"次新股",
        //"更多",
    //)
    //Column(
        //modifier=Modifier
            //.fillMaxWidth()
            //.background(Color.White)
    //){
        //for (row in 0 until 2){
            //Row(
                //modifier=Modifier.fillMaxWidth(),
                //horizontalAlignment = Alignment.CenterHorizontally
            //){
                //for (col in 0 until 5){
                    //val index=row*5+col

                //}
            //}
        //}
    //}
//}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MyApplicationTheme {
        TopBar(
            name="数据中心",
            function="更多"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FunctionPreview(){
    MyApplicationTheme{
        Function(
            image=painterResource(id=R.drawable.rectangle),
            label="开户",
            onClick={}
        )
    }
}
