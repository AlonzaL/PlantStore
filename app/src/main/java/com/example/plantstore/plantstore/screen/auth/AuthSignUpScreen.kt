package com.example.plantstore.plantstore.screen.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.R
import com.example.plantstore.plantstore.viewModel.AuthViewModel

@Composable
fun AuthSingInScreen(
    viewModel: AuthViewModel,
    onStartClick: () -> Unit,
    onBack: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var passwordsMatch = (password == passwordRepeat)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.flower_1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(16.dp)
                .graphicsLayer(
                    // А потом визуально увеличивается в 3 раза
                    scaleX = 2f,
                    scaleY = 2f
                )
                .offset(y = 50.dp),
            contentScale = ContentScale.Crop
        )


        AuthHeader(
            title = "Sign up",
            onBack = onBack
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp, start = 35.dp, end = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Box {
                    // Слой 1: Тень (простой Box)
                    Box(
                        modifier = Modifier
                            .matchParentSize() // Занимает тот же размер, что и поле ввода
                            .offset(x = 10.dp, y = 10.dp) // Смещаем тень
                            .background(
                                color = Color.Black.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .blur(radius = 8.dp) // Размываем
                    )

                    // 3. Поле для логина
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {
                            Text(
                                text = "Login",
                                color = colorResource(R.color.auth)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // Убираем подчеркивание
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = colorResource(R.color.authBg), // Белый фон
                            unfocusedContainerColor = colorResource(R.color.authBg)
                        )
                    )
                }

                if (email != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Эта почта уже зарегистрирована",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Box {
                    // Слой 1: Тень (простой Box)
                    Box(
                        modifier = Modifier
                            .matchParentSize() // Занимает тот же размер, что и поле ввода
                            .offset(x = 10.dp, y = 10.dp) // Смещаем тень
                            .background(
                                color = Color.Black.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .blur(radius = 8.dp) // Размываем
                    )

                    // 3. Поле для логина
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = {
                            Text(
                                text = "Name",
                                color = colorResource(R.color.auth)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // Убираем подчеркивание
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = colorResource(R.color.authBg), // Белый фон
                            unfocusedContainerColor = colorResource(R.color.authBg)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                Box {
                    // Слой 1: Тень (простой Box)
                    Box(
                        modifier = Modifier
                            .matchParentSize() // Занимает тот же размер, что и поле ввода
                            .offset(x = 10.dp, y = 10.dp) // Смещаем тень
                            .background(
                                color = Color.Black.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .blur(radius = 8.dp) // Размываем
                    )
                    // 4. Поле для пароля
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = {
                            Text(
                                text = "Password",
                                color = colorResource(R.color.auth)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // Убираем подчеркивание
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = colorResource(R.color.authBg), // Белый фон
                            unfocusedContainerColor = colorResource(R.color.authBg)
                        )
                    )
                }
                if (password != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = when (password.length) {
                            in 0..6 -> "Пароль слишком короткий"
                            in 7..8 -> "Пароль нормальный"
                            else -> "Пароль надёжный"
                        },
                        fontWeight = FontWeight.Bold,
                        color = when (password.length) {
                            in 0..6 -> Color.Red
                            in 7..8 -> Color.Yellow
                            else -> Color.Green
                        }
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Box {
                    // Слой 1: Тень (простой Box)
                    Box(
                        modifier = Modifier
                            .matchParentSize() // Занимает тот же размер, что и поле ввода
                            .offset(x = 10.dp, y = 10.dp) // Смещаем тень
                            .background(
                                color = Color.Black.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .blur(radius = 8.dp) // Размываем
                    )
                    // 4. Поле для пароля
                    TextField(
                        value = passwordRepeat,
                        onValueChange = { passwordRepeat = it },
                        label = {
                            Text(
                                text = "Repeat password",
                                color = colorResource(R.color.auth)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(20.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent, // Убираем подчеркивание
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = colorResource(R.color.authBg), // Белый фон
                            unfocusedContainerColor = colorResource(R.color.authBg)
                        )
                    )
                }
                if (!passwordsMatch) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Пароли не совпадают",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.height(70.dp))

            Button(
                onClick = {
                    if (passwordsMatch) viewModel.signUp(email,password)
                },
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = if (passwordsMatch)
                        colorResource(R.color.authBg)
                    else
                        colorResource(R.color.descr)
                ),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = "Start Shopping",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.authBg)
                )
            }
        }


        Spacer(modifier = Modifier.height(32.dp))
    }
}