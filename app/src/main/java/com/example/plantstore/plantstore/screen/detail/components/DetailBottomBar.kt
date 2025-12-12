package com.example.plantstore.plantstore.screen.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.DarkGreen
import com.example.plantstore.ui.theme.Favorite
import com.example.plantstore.ui.theme.TextGray

@Composable
fun DetailBottomBar(
    price: Double,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onAddToCart: () -> Unit
) {
    Surface(
        color = Color.White,
        shadowElevation = 24.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .windowInsetsPadding(WindowInsets.navigationBars),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "PRICE",
                    fontSize = 12.sp,
                    color = TextGray,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "$ $price",
                    fontSize = 20.sp,
                    color = DarkGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(
                    onClick = onFavoriteClick,
                    colors = IconButtonDefaults.outlinedIconButtonColors(
                        containerColor = if (isFavorite) Color(0xFF9BC09B) else Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(id = if (isFavorite) R.drawable.fav_filled else R.drawable.fav),
                        contentDescription = "Fav",
                        modifier = Modifier
                            .size(44.dp),
                        tint = if (isFavorite) Favorite else TextGray
                    )
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.detail_message),
                        contentDescription = "Chat",
                        modifier = Modifier
                            .size(44.dp),
                        tint = TextGray
                    )
                }

                Button(
                    onClick = onAddToCart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Black
                    ),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(43.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.btn_2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp),
                        tint = Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Add to Cart",
                        fontWeight = FontWeight.Bold,
                        color = Black
                    )

                }
            }
        }
    }
}