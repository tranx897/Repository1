package edu.uchicago.gerber.androidretro.presentation.screens.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.uchicago.gerber.androidretro.common.Constants
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel
import edu.uchicago.gerber.androidretro.presentation.widgets.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailSentScreen(movieViewModel: MovieViewModel, navController: NavController) {
    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { BottomNavigationBar(movieViewModel, navController) },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Email Sent",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )

                }
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Thank you for sending us an email!",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth() // Expand the text to full width
                    .padding(horizontal = 16.dp), // Add horizontal padding
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun EmailSentScreenPreview() {
    val navController = rememberNavController()
    val movieViewModel = MovieViewModel()
    EmailSentScreen(movieViewModel = movieViewModel, navController = navController,)
}