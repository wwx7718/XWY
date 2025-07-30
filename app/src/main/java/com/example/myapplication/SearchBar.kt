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
import androidx.compose.ui.res.painterResource


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
    modifier: Modifier=Modifier
){
    Row(
        modifier=Modifier
            //.height(64.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ){
        TextField(
            value = query,
            onValueChange = onQueryChange,
            modifier=Modifier
                //.weight(1f)
                //.height(14.dp)
                .background(Color(0xFFF5F7FB)),
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
                            onSearch()
                        }
                )
            },
            textStyle = TextStyle(color = Color(0xFF9A9EAD)),
            maxLines = 1,
            singleLine=true
        )

    }
}

@Composable
fun MySearchBar(){
    var query by remember{ mutableStateOf("") }
    Row(
        modifier=Modifier
            //.height(64.dp)
            //.wrapContentHeight()
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Profile",
            modifier = Modifier
                .size(28.dp)
                .clickable {}
                //.height(56.dp)
        )
        Spacer(modifier=Modifier.width(12.dp))
        CustomSearchBar(
            query=query,
            onQueryChange={query=it},
            onSearch = {},
            modifier=Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Image(
            painter = painterResource(id = R.drawable.moreoption),
            contentDescription = "More",
            modifier = Modifier
                .size(20.dp)
                .clickable {}
                //.height(56.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MySearchBarPreview(){
    MyApplicationTheme{
        MySearchBar()
    }
}