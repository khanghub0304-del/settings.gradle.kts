package com.novacraft.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContent { NovaCraftApp() }
}
}

@Composable
fun NovaCraftApp() {
var selected by remember { mutableStateOf("Trang chủ") }
val pages = listOf(
"Trang chủ", "Phiên bản", "Tài khoản", "Mod",
"Tài nguyên", "Điều khiển", "Đồ họa", "Cài đặt"
)

MaterialTheme(
    colorScheme = darkColorScheme(
        primary = Color(0xFFFFC928),
        background = Color(0xFF111318),
        surface = Color(0xFF1C2028)
    )
) {
    Row(
        Modifier.fillMaxSize().background(Color(0xFF111318))
    ) {
        LazyColumn(
            Modifier.width(118.dp).fillMaxHeight()
                .background(Color(0xFF191D24)).padding(8.dp)
        ) {
            items(pages.size) { index ->
                TextButton(
                    onClick = { selected = pages[index] },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        pages[index],
                        color = if (selected == pages[index])
                            Color(0xFFFFC928) else Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Column(
            Modifier.weight(1f).fillMaxHeight().padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "NOVA CRAFT",
                color = Color(0xFFFFC928),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                selected,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF242A34)
                ),
                shape = RoundedCornerShape(18.dp)
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text(
                        "Minecraft Java Edition",
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "NovaCraft Launcher • Android",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFC928),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("CHƠI NGAY")
                    }
                }
            }
            Text(
                "Chào mừng đến với NovaCraft!",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                "Đây là bản giao diện thử nghiệm. " +
                    "Chức năng chạy Minecraft chưa được tích hợp.",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
}

}
