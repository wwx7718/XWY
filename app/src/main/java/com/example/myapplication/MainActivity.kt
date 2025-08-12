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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController


//import androidx.compose.foundation.layout.Arrangement




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme (darkTheme = false){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        //TopBar(
                            //name = "数据中心",
                            //function = "更多",
                            //modifier = Modifier
                                //.padding(innerPadding)
                                //.fillMaxWidth()
                                //.padding(17.dp)
                        //)
                        //FunctionGrid(modifier = Modifier.fillMaxWidth())
                        //Screen(modifier = Modifier.fillMaxWidth())
                        //MenuScreen(modifier = Modifier.fillMaxWidth())
                        //SimpleSearchBar(
                            //modifier = Modifier.fillMaxWidth(),
                            //onSearch = {},
                            //searchResults = emptyList()
                        //)
                        //MySearchBar()
                        //MenuBarItem()
                        //MainTopBar()
                        //FigureScreen()
                        ApplicationNavHost()
                        //HomeScreen()
                    }
                }
            }
        }
    }
}



@Composable
fun TopBar(
    name:String,
    function:String,
    onFunctionClick:() -> Unit={},
    modifier:Modifier=Modifier
) {
    val colors=MaterialTheme.colorScheme
    val navController=rememberNavController()
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
                Row(
                    modifier = Modifier
                        .clickable { onFunctionClick() },
                        //.padding(end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                .padding(17.dp),
            onFunctionClick={
            }
        )
        FunctionGrid()
    }
}


@Composable
fun TopBar3(
    LeftText:String,
    MiddleText:String,
    RightText:String,
    function:String,
    selectedTab:String,
    onTabSelected: (String) -> Unit,
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
            //horizontalArrangement = Arrangement.spacedBy(25.dp)
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
fun Menu1(){
    val tabLabels = listOf("涨幅", "涨速", "主力净流入", "主力净流速", "5日涨幅", "20日涨幅")
    var selectedTab by remember{mutableStateOf(tabLabels[0])}

    MenuItem1(
        tabLabels=tabLabels,
        selectedTab=selectedTab,
        onTabSelected= {selectedTab=it}
    )
}

@Composable
fun MenuItem1(
    tabLabels: List<String>,
    selectedTab: String,
    onTabSelected:(String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(tabLabels) { index, label ->
            val isSelected = label == selectedTab
            val darkTheme = false
            Button(
                onClick = { onTabSelected(label) },
                modifier = Modifier
                    .padding(start=if(index==0)12.dp else 0.dp),
                colors = ButtonDefaults.buttonColors(
                    //containerColor = if (isSelected) Color(0xFF508CEE) else Color(0xFFF5F7FB),
                    containerColor = if (darkTheme) Color(0xFF232529) else Color(0xFFF5F7FB),
                    contentColor = if (isSelected) Color(0xFF508CEE) else Color(0xFF808595)
                ),
                shape = RoundedCornerShape(3.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
                border = BorderStroke(
                    0.5.dp,
                    if (isSelected) Color(0xFF508CEE) else Color(0xFFF5F7FB)
                )

            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = label,
                        fontSize = 13.sp
                    )
                    if (isSelected){
                        Spacer(modifier = Modifier.width(4.dp))
                        Column{
                            Icon(
                                imageVector = Icons.Filled.ArrowDropUp,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(4.dp)
                                    .width(6.dp),
                                tint = Color(0xFF508CEE)
                            )
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(4.dp)
                                    .width(6.dp),
                                tint = Color(0xFF508CEE)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Content1(
    label1:String,
    number1:String,
    label2:String,
    number2:String,
    onClick: () -> Unit
){
    Column(
        modifier=Modifier
            .width(120.dp)
            .heightIn(min=100.dp)
            .clickable{onClick()}
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text=label1,
            fontSize = 16.sp,
            color = Color(0xFF333333),
            modifier=Modifier
                //.width(64.dp)
                .height(23.dp)
                //.padding(20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = number1,
            fontSize = 18.sp,
            color = Color(0xFFFD4331),
            modifier = Modifier
                .height(20.dp)
                .align(Alignment.CenterHorizontally)
        )
            Row(
                modifier = Modifier
                    .width(120.dp)
                    .heightIn(min=13.dp)
                    .clickable{onClick()},
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text=label2,
                    fontSize = 13.sp,
                    color = Color(0xFF808595),
                    //modifier = Modifier.height(13.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text=number2,
                    fontSize = 13.sp,
                    color = Color(0xFFFD4332),
                    //modifier = Modifier.height(13.dp)
                )

            }
        }
    }

data class Items(
    val label1: String,
    val number1: String,
    val label2: String,
    val number2: String
)

@Composable
fun ContentList1(items:List<Items>){
    LazyVerticalGrid (
        columns = GridCells.Fixed(3),
    modifier=Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(9.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
){
    items(items){item->
        Content(
            label1=item.label1,
            number1=item.number1,
            label2 = item.label2,
            number2 = item.number2,
            onClick = {}
        )
    }
  }
}

@Composable
fun ContentItem1(modifier: Modifier=Modifier){
    val sampleDate= listOf(
        Item("元件", "+7.13%", "方邦股份", "+20.02%"),
        Item("地面兵装II", "+3.57%", "光电股份", "+10.02%"),
        Item("化学制药", "+3.52%", "尔康制药", "+14.63%"),
        Item("保险II","+3.40%", "新华保险", "+4.86%"),
        Item("塑料", "+2.96%", "上邦新材", "+18.32%"),
        Item("影视院线", "+2.78%", "幸福蓝海", "+20.00%")
    )
    ContentList(items=sampleDate)
}

@Composable
fun MenuScreen1(modifier: Modifier=Modifier){
    Column (modifier = Modifier
        .fillMaxSize()){
        //.verticalScroll(rememberScrollState())){
        val tabList = listOf("热门行业", "热门概念", "资金热力图")
        var selectedTab by rememberSaveable { mutableStateOf("") }
        TopBar2(
            tabs = tabList,
            function = "更多",
            selectedTab = selectedTab,
            onTabSelected = {selectedTab =it}
        )
        Menu()
        ContentItem()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    //textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    //var expanded by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    val colors=MaterialTheme.colorScheme

    if (!active) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(28.dp)
                    .clickable {}
                    //.height(56.dp)
                    .align(Alignment.CenterVertically)
                    .offset(y=16.dp)
            )

                SearchBar(
                    modifier = Modifier
                        .padding(horizontal = 9.dp)
                        .semantics { isTraversalGroup = true }
                        .height(56.dp)
                        .weight(1f),
                    //.width(279.dp),
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = {
                        onSearch(query)
                        active = false
                    },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text("Search") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Iocn"
                        )
                    },
                    trailingIcon = {
                        Text(
                            text = "搜索",
                            color = Color(0xFF508CEE),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .clickable {
                                    onSearch(query)
                                    active = false
                                }
                        )
                    },
                    shape = RoundedCornerShape(4.dp)
                ) {
                }

                Image(
                    painter = painterResource(id = R.drawable.moreoption),
                    contentDescription = "More",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {}
                        .height(56.dp)
                        .align(Alignment.CenterVertically)
                        .offset(y=16.dp)
                )
            }
    } else{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Return",
                //modifier=Modifier.offset(x=pxToDp(355.3f)),
                tint = Color(0xFF808595),
                modifier = Modifier
                    .clickable { active=false }
                    .align(Alignment.CenterVertically)
                    .offset(y=16.dp)
            )

        SearchBar(
            modifier = Modifier
                .padding(9.dp)
                .semantics { isTraversalGroup = true }
                .height(56.dp)
                //.fillMaxWidth(),
                .weight(1f),
            //.width(279.dp),
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                onSearch(query)
                active = false
            },
            active = false,
            onActiveChange = {},
            //active = active,
            //onActiveChange = { active = it },
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Iocn"
                )
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id=R.drawable.upload),
                    contentDescription = "Photo upload",
                    modifier = Modifier
                        .clickable {
                            onSearch(query)
                        }
                        .size(24.dp)
                )
            },
            shape = RoundedCornerShape(4.dp)
        ) {
        }

            Text(
                text = "搜索",
                color = Color(0xFF508CEE),
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                        onSearch(query)
                        active = false
                    }
                    .align(Alignment.CenterVertically)
                    .offset(y=16.dp)
            )
        }
    }
}

@Composable
fun MenuBarItem() {
    val tabLabels = listOf(
        "A股",
        "环球",
        "基金",
        "期货",
        "美股",
        "港股",
        "外汇",
        "债券",
        "新三板",
        "期权",
        "数字币",
        "英股"
    )
    var selectedTab by remember { mutableStateOf(tabLabels[0]) }

    MenuBar(
        tabLabels = tabLabels,
        selectedTab = selectedTab,
        onTabSelected = { selectedTab = it }
    )
}

@Composable
fun MenuBar(
    tabLabels: List<String>,
    selectedTab: String,
    onTabSelected:(String) -> Unit
) {
    val itemHeight = 34.dp
    val lineHeight = 3.dp
    val colors=MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        LazyRow(
            modifier = Modifier
                //.fillMaxWidth(),
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            itemsIndexed(tabLabels) { index, label ->
                val isSelected = label == selectedTab
                val isLast = index == tabLabels.lastIndex
                Column(
                    modifier = Modifier
                        .padding(start = if (index == 0) 12.dp else 0.dp)
                        .padding(end = if (isLast) 12.dp else 0.dp)
                        .clickable { onTabSelected(label) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val isDarkTheme = isSystemInDarkTheme()
                    Text(
                        text = label,
                        //modifier=Modifier
                        //.padding(top=6.dp, bottom = 12.dp),
                        modifier = Modifier.padding(
                            top = if (isSelected) 3.dp else 6.dp,
                            bottom = if (isSelected) 12.dp else 9.dp
                        ),
                        //textAlign = TextAlign.Center,
                        //modifier = Modifier
                        //.padding(start = if (index == 0) 12.dp else 0.dp)
                        //.clickable { onTabSelected(label) },
                        //color = if (isSelected) Color(0xFF333333) else Color(0xFF808595),
                        color = when{
                            isSelected && isDarkTheme -> Color(0xFF508CEE)
                            isSelected -> Color(0xFF333333)
                            else -> Color(0xFF808595)
                        },
                        //style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = if (isSelected) 19.sp else 16.sp
                        //)
                    )
                    if (isSelected) {
                        //Spacer(modifier=Modifier.height(9.dp))
                        Box(
                            modifier = Modifier
                                .height(3.dp)
                                .width(24.dp)
                                .background(Color(0xFF508CEE))
                        )
                    }
                }
            }
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 12.dp)
                .size(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.expandmore),
                contentDescription = "Expand",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

//@Composable
//fun HomeScreen(
    //navController: NavHostController,
    //onNavigateToSearch:() -> Unit
//){
    //val scrollState= rememberScrollState()
    //Column(
        //modifier=Modifier
            //.fillMaxSize()
            //.verticalScroll(scrollState)
    //){
        //MySearchBar(onNavigateToSearch=onNavigateToSearch, onSearch = {})
        //MenuOption()
        //FigureScreen(navController=navController)
        //MenuScreen(navController=navController)
    //}
//}



@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun TopBarPreview() {
    MyApplicationTheme {
        TopBar(
            name="数据中心",
            function="更多",
            onFunctionClick={
            }
        )
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun FunctionGridPreview(){
    MyApplicationTheme{
        FunctionGrid()
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun ScreenPreview(){
    MyApplicationTheme{
        Screen()
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun TopBar2Preview(){
    MyApplicationTheme{
        val tabList = listOf("热门行业", "热门概念", "资金热力图")
        var selectedTab by rememberSaveable { mutableStateOf("") }
        TopBar2(
            tabs = tabList,
            function = "更多",
            selectedTab = selectedTab,
            onTabSelected = {selectedTab =it},
            onFunctionClick = {}
        )
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun MenuPreview(){
    MyApplicationTheme{
        Menu()
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun ContentItemPreview(){
    MyApplicationTheme{
        ContentItem()
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun MenuScreenPreview(){
    MyApplicationTheme{
        MenuScreen()
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun SimpleSearchBarPreview(){
    MyApplicationTheme{
        SimpleSearchBar(
            searchResults = emptyList(),
            onSearch = {}
        )
    }
}

@Preview(showBackground = true)
    //, uiMode = Configuration.UI_MODE_NIGHT_YES, name="Dark Mode")
@Composable
fun MenuBarItemPreview(){
    MyApplicationTheme {
        MenuBarItem()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview(){
    //MyApplicationTheme{
        //HomeScreen(navController=navController)
    //}
//}

