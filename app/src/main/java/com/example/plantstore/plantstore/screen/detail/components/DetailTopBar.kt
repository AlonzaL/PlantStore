package com.example.plantstore.plantstore.screen.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.R
import com.example.plantstore.ui.theme.Black

@Composable
fun DetailTopBar(
    onBack: () -> Unit,
    onCart: () -> Unit,
    onSetting: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = "Back",
                tint = Black,
                modifier = Modifier
                    .size(20.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.cart),
                contentDescription = "Cart",
                tint = Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onCart() }
            )


            Icon(
                painter = painterResource(R.drawable.setting),
                contentDescription = "Setting",
                tint = Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onSetting() }
            )

        }
    }
}