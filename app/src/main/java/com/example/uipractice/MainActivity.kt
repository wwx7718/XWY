package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.uipractice.ui.theme.UIPracticeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
//import com.example.uipractice.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChatScreen(modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Greeting(name:String, modifier:Modifier=Modifier) {
    Text(
        text = "Hello $name",
        modifier = modifier
    )
}

@Composable
fun ChatScreen(modifier:Modifier=Modifier){
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())){
        ChannelBar(
            channelName="Chat",
            memberCount=313
        )
        DayHeader(
            dayString="Today"
        )
        ChatBubble(
            username="Android",
            message="Checks if the item is null and only prints non-null values item?",
            time="10:00",
            avatarRes= R.drawable.ic_launcher_foreground
        )
    }
}

@Composable
fun ChannelBar(
    channelName:String,
    memberCount:Int
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .border(width=2.dp,color=Color.Blue,shape=RoundedCornerShape(1.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically, // 居中
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier.clickable {}
        )

        // Spacer(modifier = Modifier.width(1.dp))
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally // 居中

        ) {
            Text(
                text = channelName,
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Blue).copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "$memberCount members",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Blue.copy(alpha = 0.8f))
            )
        }
        Spacer(modifier=Modifier.width(20.dp)) //平衡左右间距
    }
}

@Composable
private fun RowScope.DayHeaderLine() {
    VerticalDivider(
        modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterVertically),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    )
}

@Composable
fun DayHeader(dayString: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .height(16.dp),
    ) {
        DayHeaderLine()
        Text(
            text = dayString,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        DayHeaderLine()
    }
}

@Composable
fun ChatBubble(
    username:String,
    message:String,
    time:String,
    avatarRes:Int
) {
    val ChatBubbleShape=RoundedCornerShape(4.dp, 20.dp, 20.dp, 20.dp)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(30.dp)
                .border(width=1.dp, color=Color.Red, shape=CircleShape)
                .clip(CircleShape)
                .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier=Modifier.weight(1f).padding(end=30.dp)) {
            Text(
                text = username,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold) //文字样式：中等大小的正文字体样式、在bodyMedium的基础上将fontWeight改为Bold即加粗
            )
            Spacer(modifier = Modifier.height(5.dp))

            Box {
                Column(
                    modifier = Modifier
                        .clip(ChatBubbleShape)
                        .background(Color.LightGray)
                        .border(2.dp, Color.Gray,ChatBubbleShape)
                        .padding(10.dp)
                ) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                // Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = time,
                    style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray),
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .offset(x=5.dp, y=16.dp)
                )
            }
        }
    }
}

// @Composable
// fun ChatBubble(name: String, modifier: Modifier = Modifier) {
// Text(
// text = "Hello $name!",
// modifier = modifier
// )
// }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIPracticeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground=true)
@Composable
fun ChatBubblePreview(){
    UIPracticeTheme {
        ChatBubble(
            username="Android",
            message="Checks if the item is null and only prints non-null values item?",
            time="10:00",
            avatarRes= R.drawable.ic_launcher_foreground
        )
    }
}

@Preview(showBackground=true)
@Composable
fun ChannelBarPreview(){
    UIPracticeTheme{
        ChannelBar(
            channelName="Chat",
            memberCount=313
        )
    }
}

@Preview(showBackground=true)
@Composable
fun ChatScreenPreview(){
    UIPracticeTheme{
        ChatScreen()
    }
}

@Preview(showBackground=true)
@Composable
fun DayHeaderPreview(){
    UIPracticeTheme {
        DayHeader(dayString = "Today")
    }
}