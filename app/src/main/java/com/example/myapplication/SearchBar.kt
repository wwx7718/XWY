package com.example.myapplication

import android.app.DownloadManager.Query
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
import androidx.compose.material3.TextField
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
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
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale


//import androidx.compose.foundation.layout.Arrangement




class SearchBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
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
                        MySearchBar()
                    }
                }
            }
        }
    }
}

@Composable
fun CustomSearchBar(
    query: String,
    onSearch: ()-> Unit,
    onQueryChange:(String)->Unit,
    active:Boolean,
    onActiveChange:(Boolean)->Unit,
    modifier: Modifier=Modifier
) {
    //var query by rememberSaveable { mutableStateOf("") }
    //var active by rememberSaveable { mutableStateOf(false) }

    Column() {
        if(!active) {

            Row(
                modifier = Modifier
                    .clickable { onActiveChange(true) }
                    //.height(64.dp)
                    //.fillMaxWidth()
                    .height(32.dp)
                    .width(279.dp)
                    .background(Color(0xFFF5F7FB)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Iocn",
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (query.isEmpty()) {
                        Text(
                            text = "Search",
                            fontSize = 14.sp,
                            color = Color(0xFF9A9EAD)
                        )
                    }

                }
                //placeholder = { Text(
                //"Search",
                //fontSize = 14.sp)},
                ////modifier=Modifier.height(32.dp)) },
                //leadingIcon = {
                //Icon(
                //imageVector = Icons.Default.Search,
                //contentDescription = "Search Iocn"
                //)
                //},
                //trailingIcon = {
                Text(
                    text = "搜索",
                    color = Color(0xFF508CEE),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable {
                            onSearch()
                        }
                        .padding(horizontal = 10.dp)
                )
                //},
                //textStyle = TextStyle(
                //color = Color(0xFF9A9EAD),
                //fontSize = 14.sp),
                //maxLines = 1,
                //singleLine=true
                //)

            }
        }else{
            Row(
                modifier = Modifier
                    //.height(64.dp)
                    //.fillMaxWidth()
                    .height(32.dp)
                    .width(279.dp)
                    .background(Color(0xFFF5F7FB)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Iocn",
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (query.isEmpty()) {
                        Text(
                            text = "Search",
                            fontSize = 14.sp,
                            color = Color(0xFF9A9EAD)
                        )
                    }

                    BasicTextField(
                        value = query,
                        onValueChange = onQueryChange,
                        modifier = Modifier
                            .focusable(true),
                            //.weight(1f)
                            //.height(14.dp)
                            //.height(32.dp)
                            //.fillMaxWidth(),
                        //.align(Alignment.CenterVertically),
                        //.background(Color(0xFFF5F7FB)),
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFF9A9EAD),
                        )
                    )
                }
                Image(
                    painter = painterResource(id=R.drawable.upload),
                    contentDescription = "Photo upload",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clickable {
                            onSearch()
                            onActiveChange(true)
                        }
                        .requiredSize(24.dp)
                        //.size(24.dp)
                        .padding(horizontal = 3.dp)
                )


            }
        }
    }
}

@Composable
fun MySearchBar(
    modifier: Modifier=Modifier
) {
    var query by remember { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Column() {
        if (!active) {
            Row(
                modifier = Modifier
                    .height(64.dp)
                    //.wrapContentHeight()
                    .padding(12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {}
                        .height(32.dp)
                    //.height(56.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                CustomSearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = {active =false},
                    active = active,
                    onActiveChange = {active=it},
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .padding(end=44.dp)
                        .then(Modifier.widthIn(max=279.dp))
                )
                Spacer(modifier = Modifier.width(6.dp))

                Image(
                    painter = painterResource(id = R.drawable.moresearch),
                    //imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .requiredSize(20.dp)
                        .clickable {}
                        .padding(horizontal = 2.dp)
                    //.height(32.dp)
                    //.height(56.dp)
                )
            }
        }else{
            Row(
                modifier = Modifier
                    .height(64.dp)
                    //.wrapContentHeight()
                    .padding(12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = "Return",
                    //modifier=Modifier.offset(x=pxToDp(355.3f)),
                    tint = Color(0xFF808595),
                    modifier=Modifier
                        .clickable { active =false}
                )
                Spacer(modifier = Modifier.width(2.dp))
                CustomSearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = {active=true},
                    active = active,
                    onActiveChange = {active=it},
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        //.padding(end=44.dp)
                )
                Spacer(modifier = Modifier.width(1.dp))

                Text(
                    text = "搜索",
                    color = Color(0xFF508CEE),
                    fontSize = 14.sp,
                    modifier = Modifier
                        //.widthIn(min=40.dp)
                        //.wrapContentHeight()
                        .clickable {}
                        //.padding(horizontal = 2.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MySearchBarPreview() {
    MyApplicationTheme {
        MySearchBar()
    }
}