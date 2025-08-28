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
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScrollModifierNode
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.lazy.grid.itemsIndexed


@Composable
fun SelectGrid(
    modifier:Modifier=Modifier,
    viewModel: SelectItemsViewModel=viewModel(),
    navController:NavHostController?= null){
    //val items by viewModel.items
    val page0Items by viewModel.page0Items
    val page1Items by viewModel.page1Items
    val pagerState = rememberPagerState{2}
    //val currentPage by remember { derivedStateOf { if(gridState.firstVisibleItemIndex<3)0 else 1 } }
    LaunchedEffect(Unit){
        viewModel.loadSelectItem()
    }
    val darkTheme=true
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.height(140.dp)
            .background(color = Color(0xFFF5F7FB))
    ) {
        HorizontalPager(
            state =pagerState,
            modifier=Modifier.fillMaxWidth()
        ) {page->
            if(page == 0) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color = Color(0xFFF5F7FB)),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    items(page0Items) { selectItem ->
                        SelectItems(
                            item = selectItem,
                            navController = navController,
                            label = selectItem.label,
                            number = selectItem.number,
                            level = selectItem.level,
                            trend = selectItem.trend,
                            modifier = Modifier.clickable { navController?.navigate("placeholder") }
                        )
                    }
                }
            }else{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(color = Color(0xFFF5F7FB)),
                    contentPadding = PaddingValues(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    itemsIndexed(page1Items) { index, selectItem ->
                        if (index == 8) {
                            Column(
                                modifier = Modifier
                                    .width(119.dp)
                                    .height(90.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(119.dp)
                                        .height(41.dp)
                                        .clickable { navController?.navigate("placeholder") }
                                        .background(MaterialTheme.colorScheme.background),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(9.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.more),
                                            contentDescription = "more",
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clickable { }
                                        )
                                        Text(
                                            text = "全部指数",
                                            fontSize = 13.sp,
                                            color = if (darkTheme) Color(0xFF333333) else Color(
                                                0xFF9A9EAD
                                            )
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                    Box(
                                        modifier = Modifier
                                            .width(119.dp)
                                            .height(41.dp)
                                            .clickable { navController?.navigate("placeholder") }
                                            .background(MaterialTheme.colorScheme.background),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(7.dp)
                                        ){
                                        Image(
                                            painter=painterResource(id = R.drawable.setting),
                                            contentDescription="control",
                                            modifier = Modifier
                                                .size(18.dp)
                                                .clickable {  }
                                        )
                                        Text(
                                            text = "指数管理",
                                            fontSize = 13.sp,
                                            color = if (darkTheme) Color(0xFF333333) else Color(
                                                0xFF9A9EAD
                                            )
                                        )
                                    }
                                }
                            }
                        } else {
                            SelectItems(
                                item = selectItem,
                                navController = navController,
                                label = selectItem.label,
                                number = selectItem.number,
                                level = selectItem.level,
                                trend = selectItem.trend,
                                modifier = Modifier.clickable { navController?.navigate("placeholder") }
                            )
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        if(pagerState.currentPage == 0) Color(0xFF508CEE) else Color(0xFFE5E6F2)
                    )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        if(pagerState.currentPage == 1) Color(0xFF508CEE) else Color(0xFFE5E6F2)
                    )
            )
            }
        }
    }


@Composable
fun SelectItems(
    item:SelectItem,
    modifier: Modifier=Modifier,
    navController: NavController?= null,
    label:String,
    number:String,
    level:String,
    trend:String
){
    val darkTheme=true
        Row(
            modifier = Modifier
                //.wrapContentWidth()
                //.wrapContentHeight()
                .width(119.dp)
                .height(90.dp)
                .clickable { navController?.navigate("placeholder") }
                .background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .width(119.dp)
                    //.wrapContentWidth()
                    .height(90.dp)
                    //.clickable { navController?.navigate("placeholder") }
                    .padding(8.dp),
                //.background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = label,
                    fontSize = 13.sp,
                    color = if (darkTheme) Color(0xFF333333) else Color(0xFF9A9EAD),
                    modifier = Modifier
                        .height(20.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(6.5.dp))
                Text(
                    text = number,
                    fontSize = 20.sp,
                    //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
                    color = Color(0xFF05AA3B),
                    modifier = Modifier
                        .height(25.dp)
                        .align(Alignment.CenterHorizontally)
                )
                //Spacer(modifier = Modifier.height(7.5.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = level,
                        fontSize = 11.sp,
                        //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
                        color = Color(0xFF05AA3B),
                        modifier = Modifier
                            .height(18.dp)
                    )
                    Text(
                        text = trend,
                        fontSize = 11.sp,
                        //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
                        color = Color(0xFFFD4331),
                        modifier = Modifier
                            .height(18.dp)
                    )
                }
            }
        }
    }


data class SelectItem(
    val label:String,
    val number:String,
    val level:String,
    val trend:String
)

class SelectItemsViewModel:ViewModel(){
    //private val _items= mutableStateOf<List<SelectItem>>(emptyList())
    //val items:State<List<SelectItem>> = _items
    private val _page0Items = mutableStateOf<List<SelectItem>>(emptyList())
    val page0Items:State<List<SelectItem>> = _page0Items
    private val _page1Items = mutableStateOf<List<SelectItem>>(emptyList())
    val page1Items:State<List<SelectItem>> = _page1Items

    fun loadSelectItem(){
        viewModelScope.launch{
            _page0Items.value = listOf(
                SelectItem("上证指数", "+7.13%", "+100.30", "+20.02%"),
                SelectItem("深证成指", "+3.57%", "+100.30", "+10.02%"),
                SelectItem("创业板指", "+3.52%", "+100.30", "+14.63%")
            )
        //}
    //}
    //fun loadPage1Items(){
        //viewModelScope.launch{
            _page1Items.value = listOf(
                SelectItem("北证", "+7.13%", "+100.30", "+20.02%"),
                SelectItem("沪深", "+3.57%", "+100.30", "+10.02%"),
                SelectItem("上证", "+3.52%", "+100.30", "+14.63%"),
                SelectItem("科创", "+7.13%", "+100.30", "+20.02%"),
                SelectItem("富时中国", "+3.57%", "+100.30", "+10.02%"),
                SelectItem("中证", "+3.52%", "+100.30", "+14.63%"),
                SelectItem("科创", "+3.40%", "+100.30", "+4.86%"),
                SelectItem("中证", "+2.96%", "+100.30", "+18.32%"),
                SelectItem("影视院线", "+2.78%", "+100.30", "+20.00%")
            )
        }
    }
    //fun loadSelectItem() {
    //viewModelScope.launch {
    ////delay(1000)

    //val fetchedSelectItem = listOf(
    //SelectItem("上证指数", "+7.13%", "方邦股份", "+20.02%"),
    //SelectItem("地面兵装II", "+3.57%", "光电股份", "+10.02%"),
    //SelectItem("化学制药", "+3.52%", "尔康制药", "+14.63%")
    //)
    //_items.value=fetchedSelectItem
    //}
    //}
}

@Composable
fun SelectItems2(
    item:SelectItem,
    modifier: Modifier=Modifier,
    //navController: NavController,
    label:String,
    number:String,
    level:String,
    trend:String
){
 val darkTheme = true
    Column(
        modifier = Modifier
            .width(119.dp)
            .height(90.dp)
            .clickable {  }
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = label,
            fontSize = 13.sp,
            color = if (darkTheme) Color(0xFF333333) else Color(0xFF9A9EAD),
            modifier = Modifier
                .height(20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(6.5.dp))
        Text(
            text = number,
            fontSize = 20.sp,
            //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
            color = Color(0xFF05AA3B),
            modifier = Modifier
                .height(25.dp)
                .align(Alignment.CenterHorizontally)
        )
        //Spacer(modifier = Modifier.height(7.5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = level,
                fontSize = 11.sp,
                //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
                color = Color(0xFF05AA3B),
                modifier = Modifier
                    .height(18.dp)
            )
            Text(
                text = trend,
                fontSize = 11.sp,
                //color = if()Color(0xFFFD4331) else Color(0xFF05AA3B),
                color = Color(0xFFFD4331),
                modifier = Modifier
                    .height(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectGridPreview() {
    MyApplicationTheme {
        SelectGrid()
    }
}


