package com.example.plantstore.plantstore.screen.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R

@Composable
fun DetailBottomBar(
    price: Double
) {
    BottomAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Price".uppercase(),
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                )
                Text(
                    text = "$ $price",
                    color = colorResource(R.color.price)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.fav),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp),
                        tint = colorResource(R.color.no_fav)
                    )
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.detail_message),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp),
                        tint = colorResource(R.color.no_fav)
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.Black
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.btn_2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.padding(end = 4.dp))
                        Text(
                            text = "Add to Cart",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }


    }
}

@Composable
@Preview
fun DetailBottomBarPreview() {
    DetailBottomBar(
        price = 20.5
    )
}