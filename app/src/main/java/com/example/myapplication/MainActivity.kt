package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider


//import androidx.compose.foundation.layout.Arrangement




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopBar(
                        name = "数据中心",
                        function = "更多",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                            .padding(17.dp)
                    )
                    FunctionGrid(modifier = Modifier.fillMaxWidth())
                    Screen(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun TopBar(
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
fun FunctionItem(
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
                        .size(36.dp)
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = label,
                fontSize = 13.sp,
                color = Color(0xFF333333),
                modifier=Modifier
                    //.width(60.dp)
                    .height(23.dp)
                    //.padding(20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }


@Composable
fun FunctionGrid(modifier: Modifier=Modifier){
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
            FunctionItem(imagePath = imagePath, label = label, onClick = {})
        }

        }
    }

@Composable
fun Screen(modifier: Modifier=Modifier){
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


@Composable
fun TopBar2(
    LeftText:String,
    MiddleText:String,
    RightText:String,
    function:String,
    modifier:Modifier=Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            //.padding(vertical = 8.dp)
    ) {
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
                    text = LeftText,
                    modifier = Modifier.offset(x = 12.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = MiddleText,
                    //modifier = Modifier.offset(x = 105.dp),
                    style = TextStyle(
                        //fontFamily = pingFangFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 13.5.sp,
                        color = Color(0xFF808595)
                    )
                )
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = RightText,
                    //modifier = Modifier.offset(x = 198.dp),
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
            Text(
                text = function,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 23.sp,
                    color = Color(0xFF808595)
                )
            )
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
fun Menu(){
    val tabLabels = listOf("涨幅", "涨速", "主力净流入", "主力净流速", "5日涨幅", "20日涨幅")
    var selectedTab by remember{mutableStateOf(tabLabels[0])}

    MenuItem(
        tabLabels=tabLabels,
        selectedTab=selectedTab,
        onTabSelected= {selectedTab=it}
    )
}

@Composable
fun MenuItem(
    tabLabels: List<String>,
    selectedTab: String,
    onTabSelected:(String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(tabLabels) { label ->
            val isSelected = label == selectedTab
            FilledTonalButton(
                onClick = { onTabSelected(label) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF508CEE) else Color(0xFFF5F7FB),
                    contentColor = if (isSelected) Color(0xFFFFFFFF) else Color(0xFF808595)
                ),
                shape = RoundedCornerShape(3.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)

            ) {
                Text(
                    text = label,
                    fontSize = 13.sp
                )
            }
        }
    }
}

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
fun FunctionGridPreview(){
    MyApplicationTheme{
        FunctionGrid()
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview(){
    MyApplicationTheme{
        Screen()
    }
}

@Preview(showBackground = true)
@Composable
fun TopBar2Preview(){
    MyApplicationTheme{
        TopBar2(
            LeftText = "热门行业",
            MiddleText = "热门概念",
            RightText = "资金热力图",
            function = "更多"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview(){
    MyApplicationTheme{
        Menu()
    }
}