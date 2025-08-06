package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import coil.request.ImageRequest
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.ColorFilter



@Composable
fun TopBar1(
    name:String,
    function:String,
    modifier:Modifier=Modifier
) {
    val colors=MaterialTheme.colorScheme
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
        //.padding(vertical = 8.dp)
    )
    {
        Row(
            modifier = Modifier
                //.width(375.dp)
                .fillMaxWidth()
                .height(44.dp)
                .background(MaterialTheme.colorScheme.background),
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
        HorizontalDivider(
            color=MaterialTheme.colorScheme.outline.copy(alpha=0.3f),
            thickness=0.5.dp
        )
    }
}


@Composable
fun FunctionItems(
    imagePath: String,
    label: String,
    onClick: () -> Unit
){
    //Row(
    //modifier = Modifier
    //.fillMaxWidth()
    //.clickable{onClick()}
    //.background(Color.White),
    //verticalAlignment = Alignment.CenterVertically
    //){
    val context = LocalContext.current
    Column(
        modifier=Modifier
            .width(60.dp)
            .heightIn(min=60.dp)
            .clickable{onClick()}
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if (imagePath.startsWith("http")) {
            AsyncImage(
                //model = imagePath,
                model=ImageRequest.Builder(LocalContext.current)
                    .data(imagePath)
                    .addHeader("User-Agent", "Mozilla/5.0")
                    .crossfade(true)
                    .build(),
                contentDescription = label,
                modifier = Modifier
                    .padding(top=10.5.dp)
                    .size(36.dp)
            )
        }else {
            val resId = remember(imagePath) {
                context.resources.getIdentifier(imagePath, "drawable", context.packageName)
            }
            Image(
                painter = painterResource(id = resId),
                contentDescription = label,
                modifier = Modifier
                    .padding(top = 10.5.dp)
                    .size(36.dp),
                colorFilter = ColorFilter.tint(Color(0xFF808595))
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        val darkTheme = false
        Text(
            text = label,
            fontSize = 13.sp,
            //color = Color(0xFF333333),
            color = if (darkTheme) Color(0xFF9A9EAD) else Color(0xFF333333),
            modifier=Modifier
                //.width(60.dp)
                .height(23.dp)
                //.padding(20.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun FunctionGrid1(modifier: Modifier=Modifier){
    val labels=listOf(
        Pair("account", "开户"),
        Pair("newbonds","新股新债"),
        Pair("stock","选股"),
        Pair("industrialchain", "产业链"),
        Pair("longhubang", "龙虎榜"),
        Pair("decision", "决策商城"),
        Pair("performance", "业绩大全"),
        Pair("inquire", "机构调研"),
        Pair("stockmarket", "次新股"),
        Pair("more", "更多"),
    )
    LazyVerticalGrid(
        //columns = GridCells.Adaptive(minSize=60.dp),
        columns = GridCells.Fixed(5),
        modifier=Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ){
        items(labels){(imagePath, label) ->
            FunctionItems(imagePath = imagePath, label = label, onClick = {})
        }

    }
}

@Composable
fun FigureScreen(modifier: Modifier=Modifier){
    Column (modifier = Modifier
        .fillMaxSize()){
        //.verticalScroll(rememberScrollState())){
        TopBar(
            name = "数据中心",
            function = "更多",
            modifier = Modifier
                .padding(17.dp)
        )
        FunctionGrid()
    }
}

@Preview(showBackground = true)
//, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun TopBar1Preview() {
    MyApplicationTheme {
        TopBar1(
            name="数据中心",
            function="更多"
        )
    }
}

@Preview(showBackground = true)
//, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun FunctionGrid1Preview(){
    MyApplicationTheme{
        FunctionGrid1()
    }
}

@Preview(showBackground = true)
//, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun FigureScreenPreview(){
    MyApplicationTheme{
        FigureScreen()
    }
}