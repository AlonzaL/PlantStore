package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.R

@Composable
fun SearchSection() {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        label = {
            Text(
                text = "indoor plants",
                color = colorResource(R.color.descr)
            )
                },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    tint = colorResource(R.color.descr),
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.no_fav),
            unfocusedTextColor = colorResource(R.color.no_fav),
            unfocusedContainerColor = colorResource(R.color.no_fav),
            unfocusedIndicatorColor = colorResource(R.color.no_fav)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchSectionPreview() {
    SearchSection()
}