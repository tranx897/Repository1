package edu.uchicago.gerber.androidretro.presentation.screens.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.uchicago.gerber.androidretro.common.Constants
import edu.uchicago.gerber.androidretro.presentation.navigation.Screen
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel
import edu.uchicago.gerber.androidretro.presentation.widgets.BodyTextField
import edu.uchicago.gerber.androidretro.presentation.widgets.BottomNavigationBar
import edu.uchicago.gerber.androidretro.presentation.widgets.CustomOutlinedTextField
import edu.uchicago.gerber.androidretro.presentation.widgets.EmailTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(
    movieViewModel: MovieViewModel,
    navController: NavController)
{
    val emailText = movieViewModel.emailText.value
    val subjectText = movieViewModel.subjectText.value
    val bodyText = movieViewModel.bodyText.value

    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Contact Us",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )

                }
            )
        }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "Please email us with questions and feedback about the app",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp, color = Color.DarkGray,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            EmailTextField(
                title = "Your Email Address",
                placeHolder = "e.g. a@b.com",
                textState = emailText,
                onTextChange = movieViewModel::setEmailText,
                keyboardType = KeyboardType.Text,
                ImeAction.Done,
            )
            Spacer(modifier = Modifier.height(10.dp))

            EmailTextField(
                title = "Email Subject",
                placeHolder = "e.g. Question about viewing movies",
                textState = subjectText,
                onTextChange = movieViewModel::setSubjectText,
                keyboardType = KeyboardType.Text,
                ImeAction.Done,
            )

            Spacer(modifier = Modifier.height(10.dp))

            BodyTextField(
                title = "Email Body",
                placeHolder = "e.g. I have a question",
                textState = bodyText,
                onTextChange = movieViewModel::setBodyText,
                keyboardType = KeyboardType.Text,
                ImeAction.Done,
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    movieViewModel::onSendEmail
                    navController.navigate(Screen.EmailSent.route)
                    //Toast.makeText(activity, viewModel.playerName.value, Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),

            ) {
                Text(
                    text = "Send email",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, color = Color.White,
                    )
                )
            }


//            Text(
//                text = "Contact View",
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                textAlign = TextAlign.Center,
//                fontSize = 25.sp
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    val navController = rememberNavController()
    val movieViewModel = MovieViewModel()
    ContactScreen( movieViewModel = movieViewModel, navController = navController,)
}