package com.example.plantstore.plantstore.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantstore.plantstore.viewModel.AuthViewModel

@Composable
fun SettingsScreen(
    viewModel: AuthViewModel
) {

    Column {
        Button(
            onClick = { viewModel.signOut() }
        ) {
            Text(
                text = "Sign out"
            )
        }

        Button(
            onClick = {
                //viewModel.deleteAccount()
            }
        ) {
            Text(
                text = "Delete"
            )
        }
    }
}

//@Preview
//@Composable
//fun SettingsScreenPreview() {
//    SettingsScreen(
//
//    )
//}