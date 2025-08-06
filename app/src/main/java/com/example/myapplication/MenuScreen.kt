package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar2(
    LeftText:String,
    MiddleText:String,
    RightText:String,
    function:String,
    modifier: Modifier = Modifier
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
            color= MaterialTheme.colorScheme.outline.copy(alpha=0.3f),
            thickness=0.5.dp
        )
    }
}

@Composable
fun Menu(){
    val tabLabels = listOf("涨幅", "涨速", "主力净流入", "主力净流速", "5日涨幅", "20日涨幅")
    var selectedTab by remember{ mutableStateOf(tabLabels[0]) }

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
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(tabLabels) { index, label ->
            val isSelected = label == selectedTab
            Button(
                onClick = { onTabSelected(label) },
                modifier = Modifier
                    .padding(start=if(index==0)12.dp else 0.dp),
                colors = ButtonDefaults.buttonColors(
                    //containerColor = if (isSelected) Color(0xFF508CEE) else Color(0xFFF5F7FB),
                    containerColor = Color(0xFFF5F7FB),
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
fun Content(
    label1:String,
    number1:String,
    label2:String,
    number2:String,
    onClick: () -> Unit
){
    Column(
        modifier= Modifier
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
            modifier= Modifier
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

data class Item(
    val label1: String,
    val number1: String,
    val label2: String,
    val number2: String
)

@Composable
fun ContentList(items:List<Item>){
    LazyVerticalGrid (
        columns = GridCells.Fixed(3),
        modifier= Modifier
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
fun ContentItem(modifier: Modifier = Modifier){
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
fun MenuScreen(modifier: Modifier = Modifier){
    Column (modifier = Modifier
        .fillMaxSize()){
        //.verticalScroll(rememberScrollState())){
        TopBar2(
            LeftText = "热门行业",
            MiddleText = "热门概念",
            RightText = "资金热力图",
            function = "更多"
        )
        Menu()
        ContentItem()
    }
}